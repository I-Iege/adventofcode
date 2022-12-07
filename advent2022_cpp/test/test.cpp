#include <gtest/gtest.h>
#include "advent.h"
#include <filesystem>
using namespace lib;

TEST(TEST_AOC1, aoc1 ) {
    std::filesystem::path path = std::filesystem::current_path();
    while (path.filename().string() != "advent2022_cpp")
    {
        path = path.parent_path();
    }
    EXPECT_EQ(aoc2022_1_1(path.string() + "\\input\\input1_test.txt"), 24000);
    EXPECT_EQ(aoc2022_1_2(path.string() + "\\input\\input1_test.txt"), 45000);

    EXPECT_EQ(aoc2022_2_1(path.string() + "\\input\\input2_test.txt"), 15);
    EXPECT_EQ(aoc2022_2_1(path.string() + "\\input\\input2_win_test.txt"), 24);
    EXPECT_EQ(aoc2022_2_1(path.string() + "\\input\\input2_lose_test.txt"), 6);
    EXPECT_EQ(aoc2022_2_1(path.string() + "\\input\\input2_draw_test.txt"), 15);
    
    EXPECT_EQ(aoc2022_2_2(path.string() + "\\input\\input2_test.txt"), 12);
}