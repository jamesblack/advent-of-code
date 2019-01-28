use std::env;
use std::fs::File;
use std::io::*;

fn main() {
    let args: Vec<String> = env::args().collect();
    let part = &args[1];
    println!("Running part {}", part);

    if part == "1" {
        part1();
    }
}

struct adjustment {
    value: i32,
}

fn part1() -> Result<()> {
    let mut file = File::open("input1.txt").expect("file not found");
    let mut adjustments: Vec<adjustment>;
    for line in BufReader::new(file).lines() {
        if line?.starts_with('-') {
            let slice = line?.chars().by_ref().nth(1);
            println!("Found Neg");
        }
    }
    Ok(())
}
