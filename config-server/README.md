#Overview

This application loads and makes the **external configuration** available to rest of the applications. Note that the external configuration can be hosted either on GitHub or on local file system.

The respective applications pick up the configuration based on a `<spring.application.name>.yml` file defined in the configuration by matching the service's `spring.application.name` property defined in the `bootstrap.yml` file.
