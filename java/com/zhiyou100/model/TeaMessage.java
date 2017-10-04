package com.zhiyou100.model;

import java.sql.Timestamp;

public class TeaMessage {
	
	
	private Integer id;
	
	private Double shape;
	
	private Double colour;
	
	private Double neatness;
	
	private Double fragrance;
	
	private Double liquorColor;
	
	private Double taste;
	
	private Double infusedLeaf;
	
	private Boolean status;
	
	private Timestamp current;
	
	private String grading;
	
	private Integer gradeValue;

	public TeaMessage() {
		super();
	}

	public TeaMessage(Integer id, Double shape, Double colour, Double neatness, Double fragrance, Double liquorColor,
			Double taste, Double infusedLeaf, Boolean status, Timestamp current, String grading, Integer gradeValue) {
		super();
		this.id = id;
		this.shape = shape;
		this.colour = colour;
		this.neatness = neatness;
		this.fragrance = fragrance;
		this.liquorColor = liquorColor;
		this.taste = taste;
		this.infusedLeaf = infusedLeaf;
		this.status = status;
		this.current = current;
		this.grading = grading;
		this.gradeValue = gradeValue;
	}

	@Override
	public String toString() {
		return "TeaMessage [id=" + id + ", shape=" + shape + ", colour=" + colour + ", neatness=" + neatness
				+ ", fragrance=" + fragrance + ", liquorColor=" + liquorColor + ", taste=" + taste + ", infusedLeaf="
				+ infusedLeaf + ", status=" + status + ", current=" + current + ", grading=" + grading + ", gradeValue="
				+ gradeValue + "]";
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Double getShape() {
		return shape;
	}

	public void setShape(Double shape) {
		this.shape = shape;
	}

	public Double getColour() {
		return colour;
	}

	public void setColour(Double colour) {
		this.colour = colour;
	}

	public Double getNeatness() {
		return neatness;
	}

	public void setNeatness(Double neatness) {
		this.neatness = neatness;
	}

	public Double getFragrance() {
		return fragrance;
	}

	public void setFragrance(Double fragrance) {
		this.fragrance = fragrance;
	}

	public Double getLiquorColor() {
		return liquorColor;
	}

	public void setLiquorColor(Double liquorColor) {
		this.liquorColor = liquorColor;
	}

	public Double getTaste() {
		return taste;
	}

	public void setTaste(Double taste) {
		this.taste = taste;
	}

	public Double getInfusedLeaf() {
		return infusedLeaf;
	}

	public void setInfusedLeaf(Double infusedLeaf) {
		this.infusedLeaf = infusedLeaf;
	}

	public Boolean getStatus() {
		return status;
	}

	public void setStatus(Boolean status) {
		this.status = status;
	}

	public Timestamp getCurrent() {
		return current;
	}

	public void setCurrent(Timestamp current) {
		this.current = current;
	}

	public String getGrading() {
		return grading;
	}

	public void setGrading(String grading) {
		this.grading = grading;
	}

	public Integer getGradeValue() {
		return gradeValue;
	}

	public void setGradeValue(Integer gradeValue) {
		this.gradeValue = gradeValue;
	}
}
