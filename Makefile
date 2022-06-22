include ./env/common.mk

.PHONY: all-clear
all-clear:
	@ ./mvnw clean

.PHONY: all-install
all-install:
	@ ./mvnw clean install