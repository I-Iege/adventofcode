
#include<iostream>
#include "advent.h"
#include <filesystem>
using namespace std;

int main(int argc, char *argv[])
{
    std::filesystem::path path = std::filesystem::current_path();
    while (path.filename().string() != "advent2022_cpp")
    {
        path = path.parent_path();
    }

   cout << "AOC2020_1_1: " << lib::aoc2022_1_1(path.string() + "\\input\\input1.txt") << endl;
   cout << "AOC2020_1_2: " << lib::aoc2022_1_2(path.string() + "\\input\\input1.txt") << endl;
   cout << "AOC2020_2_1: " << lib::aoc2022_2_1(path.string() + "\\input\\input2.txt") << endl;
   cout << "AOC2020_2_2: " << lib::aoc2022_2_2(path.string() + "\\input\\input2.txt") << endl;
   cout << "AOC2020_3_1: " << lib::aoc2022_3_1(path.string() + "\\input\\input3.txt") << endl;
   cout << "AOC2020_3_2: " << lib::aoc2022_3_2(path.string() + "\\input\\input3.txt") << endl;
   return 0;
}