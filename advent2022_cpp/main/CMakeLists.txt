set(TARGET main)

file(GLOB TARGET_SRC CONFIGURE_DEPENDS "*.h" "*.cpp")

add_executable(${TARGET}
   ${TARGET_SRC}
)

target_include_directories(${TARGET} PUBLIC ${CMAKE_SOURCE_DIR}/include)

target_link_libraries(${TARGET} PRIVATE core)