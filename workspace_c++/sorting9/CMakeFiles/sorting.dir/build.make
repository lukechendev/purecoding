# CMAKE generated file: DO NOT EDIT!
# Generated by "Unix Makefiles" Generator, CMake Version 3.10

# Delete rule output on recipe failure.
.DELETE_ON_ERROR:


#=============================================================================
# Special targets provided by cmake.

# Disable implicit rules so canonical targets will work.
.SUFFIXES:


# Remove some rules from gmake that .SUFFIXES does not remove.
SUFFIXES =

.SUFFIXES: .hpux_make_needs_suffix_list


# Suppress display of executed commands.
$(VERBOSE).SILENT:


# A target that is always out of date.
cmake_force:

.PHONY : cmake_force

#=============================================================================
# Set environment variables for the build.

# The shell in which to execute make rules.
SHELL = /bin/sh

# The CMake executable.
CMAKE_COMMAND = /usr/bin/cmake

# The command to remove a file.
RM = /usr/bin/cmake -E remove -f

# Escaping for special characters.
EQUALS = =

# The top-level source directory on which CMake was run.
CMAKE_SOURCE_DIR = /home/lchen/workspace_c++/sorting9

# The top-level build directory on which CMake was run.
CMAKE_BINARY_DIR = /home/lchen/workspace_c++/sorting9

# Include any dependencies generated for this target.
include CMakeFiles/sorting.dir/depend.make

# Include the progress variables for this target.
include CMakeFiles/sorting.dir/progress.make

# Include the compile flags for this target's objects.
include CMakeFiles/sorting.dir/flags.make

CMakeFiles/sorting.dir/main.cpp.o: CMakeFiles/sorting.dir/flags.make
CMakeFiles/sorting.dir/main.cpp.o: main.cpp
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green --progress-dir=/home/lchen/workspace_c++/sorting9/CMakeFiles --progress-num=$(CMAKE_PROGRESS_1) "Building CXX object CMakeFiles/sorting.dir/main.cpp.o"
	/usr/bin/c++  $(CXX_DEFINES) $(CXX_INCLUDES) $(CXX_FLAGS) -o CMakeFiles/sorting.dir/main.cpp.o -c /home/lchen/workspace_c++/sorting9/main.cpp

CMakeFiles/sorting.dir/main.cpp.i: cmake_force
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green "Preprocessing CXX source to CMakeFiles/sorting.dir/main.cpp.i"
	/usr/bin/c++ $(CXX_DEFINES) $(CXX_INCLUDES) $(CXX_FLAGS) -E /home/lchen/workspace_c++/sorting9/main.cpp > CMakeFiles/sorting.dir/main.cpp.i

CMakeFiles/sorting.dir/main.cpp.s: cmake_force
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green "Compiling CXX source to assembly CMakeFiles/sorting.dir/main.cpp.s"
	/usr/bin/c++ $(CXX_DEFINES) $(CXX_INCLUDES) $(CXX_FLAGS) -S /home/lchen/workspace_c++/sorting9/main.cpp -o CMakeFiles/sorting.dir/main.cpp.s

CMakeFiles/sorting.dir/main.cpp.o.requires:

.PHONY : CMakeFiles/sorting.dir/main.cpp.o.requires

CMakeFiles/sorting.dir/main.cpp.o.provides: CMakeFiles/sorting.dir/main.cpp.o.requires
	$(MAKE) -f CMakeFiles/sorting.dir/build.make CMakeFiles/sorting.dir/main.cpp.o.provides.build
.PHONY : CMakeFiles/sorting.dir/main.cpp.o.provides

CMakeFiles/sorting.dir/main.cpp.o.provides.build: CMakeFiles/sorting.dir/main.cpp.o


CMakeFiles/sorting.dir/util.cpp.o: CMakeFiles/sorting.dir/flags.make
CMakeFiles/sorting.dir/util.cpp.o: util.cpp
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green --progress-dir=/home/lchen/workspace_c++/sorting9/CMakeFiles --progress-num=$(CMAKE_PROGRESS_2) "Building CXX object CMakeFiles/sorting.dir/util.cpp.o"
	/usr/bin/c++  $(CXX_DEFINES) $(CXX_INCLUDES) $(CXX_FLAGS) -o CMakeFiles/sorting.dir/util.cpp.o -c /home/lchen/workspace_c++/sorting9/util.cpp

CMakeFiles/sorting.dir/util.cpp.i: cmake_force
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green "Preprocessing CXX source to CMakeFiles/sorting.dir/util.cpp.i"
	/usr/bin/c++ $(CXX_DEFINES) $(CXX_INCLUDES) $(CXX_FLAGS) -E /home/lchen/workspace_c++/sorting9/util.cpp > CMakeFiles/sorting.dir/util.cpp.i

CMakeFiles/sorting.dir/util.cpp.s: cmake_force
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green "Compiling CXX source to assembly CMakeFiles/sorting.dir/util.cpp.s"
	/usr/bin/c++ $(CXX_DEFINES) $(CXX_INCLUDES) $(CXX_FLAGS) -S /home/lchen/workspace_c++/sorting9/util.cpp -o CMakeFiles/sorting.dir/util.cpp.s

CMakeFiles/sorting.dir/util.cpp.o.requires:

.PHONY : CMakeFiles/sorting.dir/util.cpp.o.requires

CMakeFiles/sorting.dir/util.cpp.o.provides: CMakeFiles/sorting.dir/util.cpp.o.requires
	$(MAKE) -f CMakeFiles/sorting.dir/build.make CMakeFiles/sorting.dir/util.cpp.o.provides.build
.PHONY : CMakeFiles/sorting.dir/util.cpp.o.provides

CMakeFiles/sorting.dir/util.cpp.o.provides.build: CMakeFiles/sorting.dir/util.cpp.o


CMakeFiles/sorting.dir/sorting.cpp.o: CMakeFiles/sorting.dir/flags.make
CMakeFiles/sorting.dir/sorting.cpp.o: sorting.cpp
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green --progress-dir=/home/lchen/workspace_c++/sorting9/CMakeFiles --progress-num=$(CMAKE_PROGRESS_3) "Building CXX object CMakeFiles/sorting.dir/sorting.cpp.o"
	/usr/bin/c++  $(CXX_DEFINES) $(CXX_INCLUDES) $(CXX_FLAGS) -o CMakeFiles/sorting.dir/sorting.cpp.o -c /home/lchen/workspace_c++/sorting9/sorting.cpp

CMakeFiles/sorting.dir/sorting.cpp.i: cmake_force
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green "Preprocessing CXX source to CMakeFiles/sorting.dir/sorting.cpp.i"
	/usr/bin/c++ $(CXX_DEFINES) $(CXX_INCLUDES) $(CXX_FLAGS) -E /home/lchen/workspace_c++/sorting9/sorting.cpp > CMakeFiles/sorting.dir/sorting.cpp.i

CMakeFiles/sorting.dir/sorting.cpp.s: cmake_force
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green "Compiling CXX source to assembly CMakeFiles/sorting.dir/sorting.cpp.s"
	/usr/bin/c++ $(CXX_DEFINES) $(CXX_INCLUDES) $(CXX_FLAGS) -S /home/lchen/workspace_c++/sorting9/sorting.cpp -o CMakeFiles/sorting.dir/sorting.cpp.s

CMakeFiles/sorting.dir/sorting.cpp.o.requires:

.PHONY : CMakeFiles/sorting.dir/sorting.cpp.o.requires

CMakeFiles/sorting.dir/sorting.cpp.o.provides: CMakeFiles/sorting.dir/sorting.cpp.o.requires
	$(MAKE) -f CMakeFiles/sorting.dir/build.make CMakeFiles/sorting.dir/sorting.cpp.o.provides.build
.PHONY : CMakeFiles/sorting.dir/sorting.cpp.o.provides

CMakeFiles/sorting.dir/sorting.cpp.o.provides.build: CMakeFiles/sorting.dir/sorting.cpp.o


# Object files for target sorting
sorting_OBJECTS = \
"CMakeFiles/sorting.dir/main.cpp.o" \
"CMakeFiles/sorting.dir/util.cpp.o" \
"CMakeFiles/sorting.dir/sorting.cpp.o"

# External object files for target sorting
sorting_EXTERNAL_OBJECTS =

sorting: CMakeFiles/sorting.dir/main.cpp.o
sorting: CMakeFiles/sorting.dir/util.cpp.o
sorting: CMakeFiles/sorting.dir/sorting.cpp.o
sorting: CMakeFiles/sorting.dir/build.make
sorting: CMakeFiles/sorting.dir/link.txt
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green --bold --progress-dir=/home/lchen/workspace_c++/sorting9/CMakeFiles --progress-num=$(CMAKE_PROGRESS_4) "Linking CXX executable sorting"
	$(CMAKE_COMMAND) -E cmake_link_script CMakeFiles/sorting.dir/link.txt --verbose=$(VERBOSE)

# Rule to build all files generated by this target.
CMakeFiles/sorting.dir/build: sorting

.PHONY : CMakeFiles/sorting.dir/build

CMakeFiles/sorting.dir/requires: CMakeFiles/sorting.dir/main.cpp.o.requires
CMakeFiles/sorting.dir/requires: CMakeFiles/sorting.dir/util.cpp.o.requires
CMakeFiles/sorting.dir/requires: CMakeFiles/sorting.dir/sorting.cpp.o.requires

.PHONY : CMakeFiles/sorting.dir/requires

CMakeFiles/sorting.dir/clean:
	$(CMAKE_COMMAND) -P CMakeFiles/sorting.dir/cmake_clean.cmake
.PHONY : CMakeFiles/sorting.dir/clean

CMakeFiles/sorting.dir/depend:
	cd /home/lchen/workspace_c++/sorting9 && $(CMAKE_COMMAND) -E cmake_depends "Unix Makefiles" /home/lchen/workspace_c++/sorting9 /home/lchen/workspace_c++/sorting9 /home/lchen/workspace_c++/sorting9 /home/lchen/workspace_c++/sorting9 /home/lchen/workspace_c++/sorting9/CMakeFiles/sorting.dir/DependInfo.cmake --color=$(COLOR)
.PHONY : CMakeFiles/sorting.dir/depend
