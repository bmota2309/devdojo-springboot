package br.com.devdojo.awesome.error;

import javax.annotation.Generated;

public class ValidationErrorDetails extends ErrorDetail {
	private String field;
	private String fieldMessage;
	
	@Generated("SparkTools")
	private ValidationErrorDetails(Builder builder) {
		this.setField(builder.field);
		this.setFieldMessage(builder.fieldMessage);
		this.setTitle(builder.title);
		this.setStatus(builder.status);
		this.setDetail(builder.detail);
		this.setTimestamp(builder.timestamp);
		this.setDeveloperMessage(builder.developerMessage);
	}

	private ValidationErrorDetails() {

	}

	/**
	 * Creates builder to build {@link ValidationErrorDetails}.
	 * @return created builder
	 */
	@Generated("SparkTools")
	public static Builder builder() {
		return new Builder();
	}

	public String getField() {
		return field;
	}

	public void setField(String field) {
		this.field = field;
	}

	public String getFieldMessage() {
		return fieldMessage;
	}

	public void setFieldMessage(String fieldMessage) {
		this.fieldMessage = fieldMessage;
	}

	/**
	 * Builder to build {@link ValidationErrorDetails}.
	 */
	@Generated("SparkTools")
	public static final class Builder {
		private String field;
		private String fieldMessage;
		private String title;
		private int status;
		private String detail;
		private long timestamp;
		private String developerMessage;

		private Builder() {
		}

		public Builder withTitle(String title) {
			this.title = title;
			return this;
		}
		
		public Builder withField(String field) {
			this.field = field;
			return this;
		}
		
		public Builder withFieldMessage(String fieldMessage) {
			this.fieldMessage = fieldMessage;
			return this;
		}

		public Builder withStatus(int status) {
			this.status = status;
			return this;
		}

		public Builder withDetail(String detail) {
			this.detail = detail;
			return this;
		}

		public Builder withTimestamp(long timestamp) {
			this.timestamp = timestamp;
			return this;
		}

		public Builder withDeveloperMessage(String developerMessage) {
			this.developerMessage = developerMessage;
			return this;
		}

		public ValidationErrorDetails build() {
			return new ValidationErrorDetails(this);
		}
	}

}
