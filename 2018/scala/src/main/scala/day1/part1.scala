package day1

import java.nio.file.Paths
import java.util.concurrent.Executors

import cats.effect.{ExitCode, IO, IOApp, Resource}
import fs2.{Stream, io, text}
import cats.implicits._

import scala.collection.mutable
import scala.concurrent.ExecutionContext

object part1 {
  implicit val ctxShift = IO.contextShift(ExecutionContext.global)
  private val blockingExecutionContext =
    Resource.make(
      IO(ExecutionContext.fromExecutorService(Executors.newFixedThreadPool(2)))
    )(ec => IO(ec.shutdown()))

  def run(): IO[Int] = {

    var map = mutable.Map[Int, Int](0 -> 1)
    var current: Int = 0

    Stream
      .resource(blockingExecutionContext)
      .flatMap(blockingEC => {
        io.file
          .readAll[IO](Paths.get("part1.txt"), blockingEC, 4096)
          .through(text.utf8Decode)
          .through(text.lines)
          .filter(s => !s.trim.isEmpty)
          .map(s => s.toInt)
          .repeat
          .takeWhile(value => {
            val newFreq = current + value
            current = newFreq
            map += newFreq -> (map.getOrElse(newFreq, 0) + 1)
            map.find(_._2 > 1) match {
              case Some(_) => false
              case None    => true
            }
          })
      })
      .compile
      .drain
      .map(_ => {
        map.find(_._2 > 1) match {
          case Some(some) => some._1
          case None       => 0
        }
      })
  }
}

object Main extends IOApp {
  override def run(args: List[String]): IO[ExitCode] = {
    for {
      results <- part1.run()
      _ = println(results)
    } yield ExitCode.Success

  }
}
