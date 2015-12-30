package com.marcin.pihome.integration.pojo;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@XmlRootElement(name = "CurrentWeather")
@Document(collection = "currentWeather")
public class CurrentWeather {
	@Id
	private String id;
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	@XmlElement(name = "Status")
	private String Status;
	@XmlElement(name = "Time")
	private String Time;
	@XmlElement(name = "RelativeHumidity")
	private String RelativeHumidity;
	@XmlElement(name = "Temperature")
	private String Temperature;
	@XmlElement(name = "Location")
	private String Location;
	@XmlElement(name = "SkyConditions")
	private String SkyConditions;
	@XmlElement(name = "DewPoint")
	private String DewPoint;
	@XmlElement(name = "Visibility")
	private String Visibility;
	@XmlElement(name = "Pressure")
	private String Pressure;
	@XmlElement(name = "Wind")
	private String Wind;

	public String getStatus() {
		return Status;
	}

	public void setStatus(String Status) {
		this.Status = Status;
	}

	public String getTime() {
		return Time;
	}

	public void setTime(String Time) {
		this.Time = Time;
	}

	public String getRelativeHumidity() {
		return RelativeHumidity;
	}

	public void setRelativeHumidity(String RelativeHumidity) {
		this.RelativeHumidity = RelativeHumidity;
	}

	public String getTemperature() {
		return Temperature;
	}

	public void setTemperature(String Temperature) {
		this.Temperature = Temperature;
	}

	public String getLocation() {
		return Location;
	}

	public void setLocation(String Location) {
		this.Location = Location;
	}

	public String getSkyConditions() {
		return SkyConditions;
	}

	public void setSkyConditions(String SkyConditions) {
		this.SkyConditions = SkyConditions;
	}

	public String getDewPoint() {
		return DewPoint;
	}

	public void setDewPoint(String DewPoint) {
		this.DewPoint = DewPoint;
	}

	public String getVisibility() {
		return Visibility;
	}

	public void setVisibility(String Visibility) {
		this.Visibility = Visibility;
	}

	public String getPressure() {
		return Pressure;
	}

	public void setPressure(String Pressure) {
		this.Pressure = Pressure;
	}

	public String getWind() {
		return Wind;
	}

	public void setWind(String Wind) {
		this.Wind = Wind;
	}

	@Override
	public String toString() {
		return "ClassPojo [Status = " + Status + ", Time = " + Time
				+ ", RelativeHumidity = " + RelativeHumidity
				+ ", Temperature = " + Temperature + ", Location = " + Location
				+ ", SkyConditions = " + SkyConditions + ", DewPoint = "
				+ DewPoint + ", Visibility = " + Visibility + ", Pressure = "
				+ Pressure + ", Wind = " + Wind + "]";
	}
}