package com.sun.corba.se.PortableActivationIDL.LocatorPackage;

/**
* com/sun/corba/se/PortableActivationIDL/LocatorPackage/ServerLocationPerORBHolder.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from /jenkins/workspace/8-2-build-macosx-x86_64/jdk8u261/295/corba/src/share/classes/com/sun/corba/se/PortableActivationIDL/activation.idl
* Thursday, June 18, 2020 6:39:16 AM GMT
*/

public final class ServerLocationPerORBHolder implements org.omg.CORBA.portable.Streamable
{
  public com.sun.corba.se.PortableActivationIDL.LocatorPackage.ServerLocationPerORB value = null;

  public ServerLocationPerORBHolder ()
  {
  }

  public ServerLocationPerORBHolder (com.sun.corba.se.PortableActivationIDL.LocatorPackage.ServerLocationPerORB initialValue)
  {
    value = initialValue;
  }

  public void _read (org.omg.CORBA.portable.InputStream i)
  {
    value = com.sun.corba.se.PortableActivationIDL.LocatorPackage.ServerLocationPerORBHelper.read (i);
  }

  public void _write (org.omg.CORBA.portable.OutputStream o)
  {
    com.sun.corba.se.PortableActivationIDL.LocatorPackage.ServerLocationPerORBHelper.write (o, value);
  }

  public org.omg.CORBA.TypeCode _type ()
  {
    return com.sun.corba.se.PortableActivationIDL.LocatorPackage.ServerLocationPerORBHelper.type ();
  }

}