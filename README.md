# skkj-bs-sdk(sdk for skkj-basic-service)
该 SDK 是公司的基础服务的 SDK。包括以下部分：



## 环境要求

> java:1.8

> springboot:2.0.0 以上



## 使用（Maven）

```xml
<dependency>
    <groupId>com.github.yunwjr</groupId>
    <artifactId>bs-sdk</artifactId>
    <version>0.0.2</version>
</dependency>
```



配置 yml：

```yml
skkj:
  sbs:
    server-host: host
    auth:
      username: username
      password: password
```



## 各模块说明：

### 一、OAuth2授权

授权模块，自动授权，需要配置username、password



### 二、消息模块（message）



获取消息模板、发送消息等



```java
    @Autowired
    private MessageServer messageServer;
    
    
    @GetMapping("msgTest")
    @ApiOperation("消息服务测试")
    @NoNeedAccessAuth
    public RspDataT<MessageVo> msgTest() {
        MessageDto dto = new MessageDto();
        dto.setTemplateId(2L);
        List<String> tg = new ArrayList<>();
        tg.add("13000000000");
        tg.add("13200000000");
        dto.setTargetList(tg);

        dto.setParaMap(new HashMap<>());
        dto.getParaMap().put("templateParam", "{code:123321}");
        dto.getParaMap().put("param", "bbca,32123");

        SbsRsp<MessageVo> vo = messageServer.sendMessage(dto);

        return RspDataT.SurBean(vo.getData());
    }

```



### 三、日志服务（待添加）



### 四、版本管理（待添加）



### 五、报警管理（待添加）



### 六、NLP（待添加）



### 七、其他（待添加）



