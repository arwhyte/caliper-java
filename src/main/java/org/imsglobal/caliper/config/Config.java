package org.imsglobal.caliper.config;


import org.imsglobal.caliper.validators.SensorValidator;

/**
 * Caliper Sensor config settings.  Review default constants and update placeholder entries as required.
 */
public class Config {
    private final DataFormat dataFormat;
    private final String dataVersion;
    private final String jsonldExternalCaliperContext;
    private final String testFixturesBaseDir;
    private final int uuidVersion;

    /**
     * Default data format and version.
     */
    public static final DataFormat DATA_FORMAT = DataFormat.CALIPER_JSONLD;
    public static final String DATA_VERSION = "http://purl.imsglobal.org/ctx/caliper/v1p2";

    /**
     * Default IMS Caliper external context document IRI.
     */
    public static final String JSONLD_EXTERNAL_CALIPER_CONTEXT = "http://purl.imsglobal.org/ctx/caliper/v1p2";

    /**
     * Default test fixtures directory path
     */
    public static final String TEST_FIXTURES_BASE_DIR = "../caliper-common-fixtures/src/test/resources/fixtures/";

    /**
     * Default UUID version to use when minting Event UUIDs.
     */
    public static final int UUID_VERSION = 4;

    /**
     * Constructor
     * @param builder
     */
    private Config(ConfigBuilder builder) {

        this.dataFormat = (builder.dataFormat != null) ? builder.dataFormat : DATA_FORMAT;
        this.dataVersion = SensorValidator.chkStrValue(builder.dataVersion, DATA_VERSION);
        this.jsonldExternalCaliperContext = SensorValidator.chkStrValue(builder.jsonldExternalCaliperContext, JSONLD_EXTERNAL_CALIPER_CONTEXT);
        this.testFixturesBaseDir = SensorValidator.chkStrValue(builder.testFixturesBaseDir, TEST_FIXTURES_BASE_DIR);
        this.uuidVersion = SensorValidator.chkIntValue(builder.uuidVersion, UUID_VERSION);
    }

    /**
     * Get the data format.
     * @return data format
     */
    public DataFormat getDataFormat() {
        return dataFormat;
    }

    /**
     * Get the data version.
     * @return data version
     */
    public String getDataVersion() {
        return dataVersion;
    }

    /**
     * Get the external Caliper JSON-LD context URI.
     * @return the external Caliper JSON-LD context URI
     */
    public String getJsonldExternalCaliperContext() {
        return jsonldExternalCaliperContext;
    }

    /**
     * Get the test fixtures base directory path.
     * @return test fixtures base directory path
     */
    public String getTestFixturesBaseDir() {
        return testFixturesBaseDir;
    }

    /**
     * Get the UUID version to be used when minting Event UUIDs.
     * @return UUID version
     */
    private int getUuidVersion() {
        return uuidVersion;
    }

    /**
     * Builder class provides a fluid interface for config settings.
     */
    public static class ConfigBuilder {
        private DataFormat dataFormat;
        private String dataVersion;
        private String jsonldExternalCaliperContext;
        private String testFixturesBaseDir;
        private int uuidVersion = 4;

        /**
         * Constructor
         */
        public ConfigBuilder() {

        }

        /**
         * @param dataFormat
         * @return builder
         */
        public ConfigBuilder dataFormat(final DataFormat dataFormat) {
            this.dataFormat = dataFormat;
            return this;
        }

        /**
         * @param dataVersion
         * @return builder
         */
        public ConfigBuilder dataVersion(final String dataVersion) {
            this.dataVersion = dataVersion;
            return this;
        }

        /**
         * @param jsonldExternalCaliperContext
         * @return builder
         */
        public ConfigBuilder jsonldExternalCaliperContext(final String jsonldExternalCaliperContext) {
            this.jsonldExternalCaliperContext = jsonldExternalCaliperContext;
            return this;
        }

        /**
         * @param testFixturesBaseDir
         * @return builder
         */
        public ConfigBuilder testFixturesBaseDir(final String testFixturesBaseDir) {
            this.testFixturesBaseDir = testFixturesBaseDir;
            return this;
        }

        /**
         * @param uuidVersion
         * @return builder
         */
        public ConfigBuilder uuidVersion(final int uuidVersion) {
            this.uuidVersion = uuidVersion;
            return this;
        }

        /**
         * Client invokes build method in order to create an immutable object.
         * @return a new instance of Config.
         */
        public Config build() {
            return new Config(this);
        }
    }

    /**
     * Static Factory method.
     * @return new builder instance
     */
    public static ConfigBuilder builder() {
        return new ConfigBuilder();
    }
}