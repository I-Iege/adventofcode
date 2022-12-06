set(TARGET core)

file(GLOB TARGET_SRC CONFIGURE_DEPENDS "*.h" "*.cpp")

add_library(${TARGET} STATIC
   ${TARGET_SRC}
)

target_include_directories(${TARGET} PUBLIC ${CMAKE_CURRENT_SOURCE_DIR})