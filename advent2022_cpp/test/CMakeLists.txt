set(TARGET test_lib)

file(GLOB TARGET_SRC CONFIGURE_DEPENDS "*.h" "*.cpp")

add_executable(${TARGET}
    ${TARGET_SRC}
)

target_include_directories(${TARGET} PUBLIC ${CMAKE_SOURCE_DIR}/include)
target_link_libraries(${TARGET} PRIVATE gtest_main core)


add_test(NAME ${TARGET} COMMAND ${TARGET})
