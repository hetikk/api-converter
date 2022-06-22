.PHONY: converter-tests
converter-tests:
	@ ./mvnw -pl :apiconv-converter clean test

.PHONY: converter-package
converter-package:
	@ ./mvnw -pl :apiconv-converter clean package

.PHONY: converter-package-without-tests
converter-package-without-tests:
	@ ./mvnw -pl :apiconv-converter clean package -DskipTests=true

.PHONY: converter-install
converter-install:
	@ ./mvnw -pl :apiconv-converter clean install