.PHONY: common-tests
common-tests:
	@ ./mvnw -pl :apiconv-common clean test

.PHONY: common-package
common-package:
	@ ./mvnw -pl :apiconv-common clean package

.PHONY: common-package-without-tests
common-package-without-tests:
	@ ./mvnw -pl :apiconv-common clean package -DskipTests=true

.PHONY: common-install
common-install:
	@ ./mvnw -pl :apiconv-common clean install