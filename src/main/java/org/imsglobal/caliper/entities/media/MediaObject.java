package org.imsglobal.caliper.entities.media;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import org.imsglobal.caliper.entities.DigitalResource;

/**
 * An image, video, or audio object embedded in a web page.
 */
@JsonPropertyOrder({
    "@id",
    "@type",
    "name",
    "objectType",
    "alignedLearningObjective",
    "keywords",
    "isPartOf",
    "dateModified",
    "duration" })
public abstract class MediaObject extends DigitalResource implements org.imsglobal.caliper.entities.schemadotorg.MediaObject {

    public enum Type {
        AUDIO_OBJECT("http://purl.imsglobal.org/caliper/v1/AudioObject"),
        IMAGE_OBJECT("http://purl.imsglobal.org/caliper/v1/ImageObject"),
        VIDEO_OBJECT("http://purl.imsglobal.org/caliper/v1/VideoObject");

        private final String uri;

        /**
         * Private constructor
         * @param uri
         */
        private Type(final String uri) {
            this.uri = uri;
        }

        /**
         * @return URI string
         */
        public String uri() {
            return uri;
        }
    }

    @JsonProperty("@type")
    private final String type;

    @JsonProperty("duration")
    private long duration;

    /**
     * @param builder apply builder object properties to the MediaObject object.
     */
    protected MediaObject(Builder<?> builder) {
        super(builder);
        this.type = builder.type;
        this.duration = builder.duration;
    }

    /**
     * @return the type
     */
    @Override
    public String getType() {
        return type;
    }

    /**
     * @return duration
     */
    public long getDuration() {
        return duration;
    }

    /**
     * Initialize default parameter values in the builder (not in the outer profile class).  Given the abstract nature
     * of Profile, the builder's .build() method is omitted.
     * @param <T> builder
     */
    public static abstract class Builder<T extends Builder<T>> extends DigitalResource.Builder<T> {
        private String type;
        private long duration;

        protected abstract T self();

        /**
         * Initialize type with default value.  Required if builder().type() is not set by user.
         */
        public Builder() {
            type(DigitalResource.Type.MEDIA_OBJECT.uri());
        }

        /**
         * @param type
         * @return builder.
         */
        private T type(String type) {
            this.type = type;
            return self();
        }

        /**
         * @param duration
         * @return duration
         */
        public T duration(long duration) {
            this.duration = duration;
            return self();
        }
    }

    /**
     *
     */
    private static class Builder2 extends Builder<Builder2> {
        @Override
        protected Builder2 self() {
            return this;
        }
    }
}
