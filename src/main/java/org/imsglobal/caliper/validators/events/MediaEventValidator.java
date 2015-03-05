package org.imsglobal.caliper.validators.events;

import org.imsglobal.caliper.entities.media.MediaObject;
import org.imsglobal.caliper.events.MediaEvent;
import org.imsglobal.caliper.validators.ValidatorResult;

import javax.annotation.Nonnull;

public class MediaEventValidator extends EventValidator<MediaEvent> {

    /**
     * Constructor
     */
     private MediaEventValidator(String actionKey) {
        super(actionKey);
     }

    /**
     * Static factory method that sets the action key for validator comparison checks.
     * @return a new instance of MediaEventValidator.
     */
     public static MediaEventValidator action(String actionKey) {
        return new MediaEventValidator(actionKey);
     }

    /**
     * Convenience method that provides a rollup of MediaEvent property validators.
     * @param event
     * @return
     */
    @Override
    public ValidatorResult validate(@Nonnull MediaEvent event) {
        ValidatorResult result = new ValidatorResult();
        String context = event.getClass().getSimpleName();

        ValidatorResult contextURI = validateContextURI(context, event.getContext());
        if (!contextURI.isValid()) {
            result.errorMessage().appendViolation(contextURI.errorMessage().toString());
        }

        ValidatorResult typeURI = validateTypeURI(context, event.getType());
        if (!typeURI.isValid()) {
            result.errorMessage().appendViolation(typeURI.errorMessage().toString());
        }

        ValidatorResult actor = validateActorIsPerson(context, event.getActor());
        if (!actor.isValid()) {
            result.errorMessage().appendViolation(actor.errorMessage().toString());
        }

        ValidatorResult object = validateObjectIsMedia(context, event.getObject());
        if (!object.isValid()) {
            result.errorMessage().appendViolation(object.errorMessage().toString());
        }

        ValidatorResult start = validateStartTime(context, event.getStartedAtTime(), event.getEndedAtTime());
        if (!start.isValid()) {
            result.errorMessage().appendViolation(start.errorMessage().toString());
        }

        ValidatorResult duration = validateDuration(context, event.getStartedAtTime(), event.getEndedAtTime(), event.getDuration());
        if (!duration.isValid()) {
            result.errorMessage().appendViolation(duration.errorMessage().toString());
        }

        if (result.errorMessage().length() == 0) {
            result.setIsValid(true);
        } else {
            result.errorMessage().endMessage("Caliper MediaEvent conformance:");
        }

        return result;
    }

    /**
     * Validate that the object is a media object.
     * @param context
     * @param object
     * @return
     */
    public ValidatorResult validateObjectIsMedia(@Nonnull String context, @Nonnull Object object) {
        EventValidatorUtils utils = EventValidatorUtils.context(context);
        return utils.validateType(object, MediaObject.class);
    }
}