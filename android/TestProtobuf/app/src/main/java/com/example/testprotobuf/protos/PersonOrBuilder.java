// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: addressbook.proto

package com.example.testprotobuf.protos;

public interface PersonOrBuilder extends
    // @@protoc_insertion_point(interface_extends:testprotobuf.Person)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <code>int32 name = 1;</code>
   * @return The name.
   */
  int getName();

  /**
   * <pre>
   * Unique ID number for this person.
   * </pre>
   *
   * <code>int32 id = 2;</code>
   * @return The id.
   */
  int getId();

  /**
   * <code>string email = 3;</code>
   * @return The email.
   */
  java.lang.String getEmail();
  /**
   * <code>string email = 3;</code>
   * @return The bytes for email.
   */
  com.google.protobuf.ByteString
      getEmailBytes();

  /**
   * <code>repeated .testprotobuf.Person.PhoneNumber phones = 4;</code>
   */
  java.util.List<com.example.testprotobuf.protos.Person.PhoneNumber> 
      getPhonesList();
  /**
   * <code>repeated .testprotobuf.Person.PhoneNumber phones = 4;</code>
   */
  com.example.testprotobuf.protos.Person.PhoneNumber getPhones(int index);
  /**
   * <code>repeated .testprotobuf.Person.PhoneNumber phones = 4;</code>
   */
  int getPhonesCount();
  /**
   * <code>repeated .testprotobuf.Person.PhoneNumber phones = 4;</code>
   */
  java.util.List<? extends com.example.testprotobuf.protos.Person.PhoneNumberOrBuilder> 
      getPhonesOrBuilderList();
  /**
   * <code>repeated .testprotobuf.Person.PhoneNumber phones = 4;</code>
   */
  com.example.testprotobuf.protos.Person.PhoneNumberOrBuilder getPhonesOrBuilder(
      int index);

  /**
   * <code>.google.protobuf.Timestamp last_updated = 5;</code>
   * @return Whether the lastUpdated field is set.
   */
  boolean hasLastUpdated();
  /**
   * <code>.google.protobuf.Timestamp last_updated = 5;</code>
   * @return The lastUpdated.
   */
  com.google.protobuf.Timestamp getLastUpdated();
  /**
   * <code>.google.protobuf.Timestamp last_updated = 5;</code>
   */
  com.google.protobuf.TimestampOrBuilder getLastUpdatedOrBuilder();
}
