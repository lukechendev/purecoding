// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: addressbook.proto

package com.example.testprotobuf.protos;

public final class AddressBookProtos {
  private AddressBookProtos() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistryLite registry) {
  }

  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
    registerAllExtensions(
        (com.google.protobuf.ExtensionRegistryLite) registry);
  }
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_testprotobuf_Person_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_testprotobuf_Person_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_testprotobuf_Person_PhoneNumber_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_testprotobuf_Person_PhoneNumber_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_testprotobuf_AddressBook_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_testprotobuf_AddressBook_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\n\021addressbook.proto\022\014testprotobuf\032\037googl" +
      "e/protobuf/timestamp.proto\"\217\002\n\006Person\022\014\n" +
      "\004name\030\001 \001(\t\022\n\n\002id\030\002 \001(\005\022\r\n\005email\030\003 \001(\t\0220" +
      "\n\006phones\030\004 \003(\0132 .testprotobuf.Person.Pho" +
      "neNumber\0220\n\014last_updated\030\005 \001(\0132\032.google." +
      "protobuf.Timestamp\032K\n\013PhoneNumber\022\016\n\006num" +
      "ber\030\001 \001(\t\022,\n\004type\030\002 \001(\0162\036.testprotobuf.P" +
      "erson.PhoneType\"+\n\tPhoneType\022\n\n\006MOBILE\020\000" +
      "\022\010\n\004HOME\020\001\022\010\n\004WORK\020\002\"3\n\013AddressBook\022$\n\006p" +
      "eople\030\001 \003(\0132\024.testprotobuf.PersonB6\n\037com" +
      ".example.testprotobuf.protosB\021AddressBoo" +
      "kProtosP\001b\006proto3"
    };
    descriptor = com.google.protobuf.Descriptors.FileDescriptor
      .internalBuildGeneratedFileFrom(descriptorData,
        new com.google.protobuf.Descriptors.FileDescriptor[] {
          com.google.protobuf.TimestampProto.getDescriptor(),
        });
    internal_static_testprotobuf_Person_descriptor =
      getDescriptor().getMessageTypes().get(0);
    internal_static_testprotobuf_Person_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_testprotobuf_Person_descriptor,
        new java.lang.String[] { "Name", "Id", "Email", "Phones", "LastUpdated", });
    internal_static_testprotobuf_Person_PhoneNumber_descriptor =
      internal_static_testprotobuf_Person_descriptor.getNestedTypes().get(0);
    internal_static_testprotobuf_Person_PhoneNumber_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_testprotobuf_Person_PhoneNumber_descriptor,
        new java.lang.String[] { "Number", "Type", });
    internal_static_testprotobuf_AddressBook_descriptor =
      getDescriptor().getMessageTypes().get(1);
    internal_static_testprotobuf_AddressBook_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_testprotobuf_AddressBook_descriptor,
        new java.lang.String[] { "People", });
    com.google.protobuf.TimestampProto.getDescriptor();
  }

  // @@protoc_insertion_point(outer_class_scope)
}
