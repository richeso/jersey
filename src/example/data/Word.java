package example.data;

import java.io.Serializable;
import java.util.Random;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Word implements Serializable {
	@Id
	@GeneratedValue
	private Integer id;

	@Column(nullable = false)
	private String value;

	@Column(nullable = false)
	private Integer points;

	public Word () {
		value  = "";
		points = new Integer(0);
	}
	public Word (String aValue, Integer aPoints){
		this.value = aValue;
		this.points = aPoints;
	}
	public String scrambled() {
		return scramble(value, new Random(System.currentTimeMillis()));
	}

	private static String scramble(String str, Random rand) {
		if (str.length() == 1)
			return str;
		int idx = (int) (rand.nextFloat() * str.length());
		return scramble(exclude(str, idx), rand) + str.charAt(idx);
	}

	private static String exclude(String str, int idx) {
		return idx == str.length() - 1 ? str.substring(0, idx) : str.substring(
				0, idx)
				+ str.substring(idx + 1);
	}

	public Integer getId() {
		return id;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public Integer getPoints() {
		return points;
	}

	public void setPoints(Integer points) {
		this.points = points;
	}
}
