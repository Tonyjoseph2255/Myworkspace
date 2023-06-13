package com.example.itemjson.entity;

import java.util.Date;
import java.util.List;

import org.json.simple.JSONObject;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;



@Getter
@Setter
@ToString
@JsonPropertyOrder({"id", "itemnumber", "signing1desc","modifiedDate"})

public class ItemEntity {
	public List id;
	public List itemnumber;
	public List signing1desc;
	public List modifiedDate;

}
