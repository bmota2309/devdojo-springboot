package br.com.devdojo.awesome.error;

import javax.annotation.Generated;

public class ResourceNotFoundDetails extends ErrorDetail{

	@Generated("SparkTools")
	private ResourceNotFoundDetails(Builder builder) {
		this.setTitle(builder.title);
		this.setStatus(builder.status);
		this.setDetail(builder.detail);
		this.setTimestamp(builder.timestamp);
		this.setDeveloperMessage(builder.developerMessage);
	}

	private ResourceNotFoundDetails() {

	}

	/**
	 * Creates builder to build {@link ResourceNotFoundDetails}.
	 * @return created builder
	 */
	@Generated("SparkTools")
	public static Builder builder() {
		return new Builder();
	}

	/**
	 * Builder to build {@link ResourceNotFoundDetails}.
	 */
	@Generated("SparkTools")
	public static final class Builder {
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

		public ResourceNotFoundDetails build() {
			return new ResourceNotFoundDetails(this);
		}
	}

}
