package yelp;

import java.io.Serializable;

/**
 * Represents a Yelp restaurant
 * @author Thomas Peters
 */
public class Restaurant implements Serializable {

	private static final long serialVersionUID = -6431566946329033409L;

	private String name;
	private String image_url;
	private String url;
	private double rating;
	private String price;
	private String phone;
	private Location location;
	
	public String getName() {
		return name;
	}

	public String getImage_url() {
		return image_url;
	}

	public String getUrl() {
		return url;
	}

	public double getRating() {
		return rating;
	}

	public String getPrice() {
		return price;
	}

	public String getPhone() {
		return phone;
	}
	
	public Location getLocation() {
		return location;
	}
}
