#!/bin/bash

# Set the main branch name
main_branch=lessonMain

# Set the pattern to match
pattern=lessonMain

# Get the list of branches
branches=($(git branch --no-color --list))

# Check out the main branch
git checkout $main_branch

# Loop through the list of branches
for branch in "${branches[@]}"
do
  # Strip the leading "* " from the branch name
  branch=${branch#"* "}

  # Skip branches that do not match the pattern
  if [[ ! $branch =~ ^\*?\s*$pattern ]]
  then
    continue
  fi

  # Check out the current branch
  git checkout $branch

  # Pull the latest changes from the remote repository
  git pull origin $branch

  # Merge the current branch into the main branch
  git checkout $main_branch
  git merge $branch
done