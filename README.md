# tfass_lsp
一、	应用架构
 

该系统技术框架：
1)	前段： React
2)	后端：Spring boot 实现的Restful
3)	管理平台： Extjs4
4)	Java版本：Jdk7
5)	构建工具：Maven 3.3
6)	中间件：Spring boot Embed Tomcat 7
工程使用Maven Build以后，会在主工程CoreProject的target目录下生成Executeabl Jar，运行系统的方式只要在cmd中输入指令：
Java –jar [application].jar 即可
前段React的运行方式需要安装nodejs，安装完成后进入所需要更改的模块目录，在cmd中执行如下命令（这个只有首次变更的时候需要）来安装依赖包：
Npm install
命令执行完成后，如未遇到异常。则继续在命令行执行：
Npm start
即可开始运行应用进行调试，在浏览器中访问地址为：localhost:8090
