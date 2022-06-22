include ./env/common.mk
include ./env/converter.mk

.PHONY: all-clear
all-clear:
	@ ./mvnw clean

.PHONY: all-compile
all-compile:
	@ ./mvnw clean compile

.PHONY: all-install
all-install:
	@ ./mvnw clean install