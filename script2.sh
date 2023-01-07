#!/bin/bash

# Set the main branch name
main_branch=lessonMain

# Set the pattern to match
pattern=lessonMain

# Get the list of branches
branches=$(git branch --no-color --list | grep "$pattern")
echo "result: $branches"
# Check out the main branch
git checkout $main_branch

# Loop through the list of branches
for branch in "${branches[@]}"
do
  # Strip the leading "* " from the branch name
  branch=${branch#"* "}

  # Merge the current branch into the main branch
  git merge $branch
done