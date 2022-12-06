#include <gtest/gtest.h>
#include "advent.h"

using namespace lib;

TEST(TEST_AOC1, aoc1 ) {
    EXPECT_EQ(aoc2022_1_1("..\\..\\..\\input\\input1_test.txt"), 24000);
    EXPECT_EQ(aoc2022_1_2("..\\..\\..\\input\\input1_test.txt"), 45000);
    EXPECT_EQ(aoc2022_2_1("..\\..\\..\\input\\input2_test.txt"), 15);
}