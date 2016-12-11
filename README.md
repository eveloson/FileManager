# FileManager 

A ServerFileManager which you can upload and download file.
```
src
└── com
    └── file
        ├── annotation
        │   └── DocAnnotation.java
        ├── conf
        │   ├── mybatis-config.xml
        │   ├── spring-base.xml
        │   ├── springmvc-base.xml
        │   ├── ssm-c3p0-mysql.properties
        │   └── upload.properties
        ├── controller
        │   ├── DocController.java
        │   ├── UserController.java
        │   └── YZMController.java
        ├── customexception
        │   └── ResourceNotFoundException.java
        ├── interceptor
        │   └── LoginInterceptor.java
        ├── listener
        │   └── UploadServletContextListener.java
        ├── mapper
        │   ├── DocMapper.java
        │   ├── UserMapper.java
        │   └── xml
        │       ├── DocMapper.xml
        │       └── UserMapper.xml
        ├── service
        │   ├── DocService.java
        │   ├── UserService.java
        │   └── impl
        │       ├── DocServiceImpl.java
        │       └── UserServiceImpl.java
        ├── utils
        │   ├── DateFormatUtil.java
        │   ├── EncryptUtil.java
        │   ├── FileTransferUtil.java
        │   ├── ImgFontByte.java
        │   ├── UtilFile.java
        │   └── ValidateCode.java
        └── vo
            ├── Doc.java
            ├── Page.java
            └── User.java

