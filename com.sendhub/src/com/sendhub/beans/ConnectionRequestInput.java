package com.sendhub.beans;

import java.util.Arrays;
import java.util.List;

public class ConnectionRequestInput {
	String title;
	String message;
	List<String> recipients;

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public List<String> getRecipients() {
		return recipients;
	}

	public void setRecipients(String[] recipients) {
		this.recipients = Arrays.asList(recipients);
	}

	@Override
	public String toString() {
		return "ConnectionRequestInput [title=" + title + ", message="
				+ message + ", recipients=" + recipients + "]";
	}
}
