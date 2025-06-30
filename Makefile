# Makefile for Maven project

# Variables
MAVEN_CMD = mvn
SPRING_BOOT_PROFILE = dev

# Default target
.PHONY: default
default: run

# Clean project
.PHONY: clean
clean:
	$(MAVEN_CMD) clean

# Compile the project
.PHONY: compile
compile:
	$(MAVEN_CMD) compile

# Run tests
.PHONY: test
test:
	$(MAVEN_CMD) test

# Package the application
.PHONY: package
package:
	$(MAVEN_CMD) package

# Install to local repository
.PHONY: install
install:
	$(MAVEN_CMD) install

# Run the application (for Spring Boot)
.PHONY: run
run:
	$(MAVEN_CMD) spring-boot:run -Dspring-boot.run.profiles=$(SPRING_BOOT_PROFILE)

# Run with custom profile
.PHONY: run-profile
run-profile:
	@read -p "Enter profile name: " profile; \
	$(MAVEN_CMD) spring-boot:run -Dspring-boot.run.profiles=$$profile

# Help command
.PHONY: help
help:
	@echo "Available commands:"
	@echo "  make          : Run the application"
	@echo "  make clean    : Clean the project"
	@echo "  make compile  : Compile the project"
	@echo "  make test     : Run tests"
	@echo "  make package  : Package the application"
	@echo "  make install  : Install to local repository"
	@echo "  make run      : Run the Spring Boot application"
	@echo "  make run-profile : Run with custom profile"