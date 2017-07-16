# Java2Sql

## Introduce
java2sql 是一款基于java代码开发的多平台程序。通过简单的命令生成和迁移填充数据库数据。
受 Laravel Artisan Migrate/Seeder 功能启发开发而成。
----------------------------------------
## Features
- 利用简单的 Java 代码书写，Java开发者的自然优越感
- 用命令行操作，使用更加简单
- 代码复用率更高

## Todo
- [x] DatabaseAdapter
- [x] TableAdapter
- [x] FieldAdapter
- [x] MysqlAdapter
- [x] MysqlTableAdapter
- [x] MysqlFieldAdapter
- [x] Migration
- [ ] Seed
- [ ] 迁移文件、数据填充生成
- [ ] Console/Terminal 上运行
- [ ] 优化代码
- [ ] 进入不定期维护阶段

## Requirements
- Windows/Linux/macOS
- JDK 1.7+
## Installation
下载`target`文件夹下的`java2sql*.jar`文件到生产环境下即可。
> 如需在系统中全局运行请将该文件所在文件夹路径设置到环境变量
- Windows 下请设置到 计算机->属性->高级系统设置->环境变量->系统变量->Path
- macOS 
- Ubuntu 
## Quick Start

- `Seeds` 文件夹存放生成的数据库表填充数据文件
- `Migrations` 文件夹存放生成的数据表迁移文件

- `migration:UsersMigration` 生成名为UsersMigration的迁移文件
- `migrate:UsersMigration` 迁移名为UsersMigration的迁移文件，目标名为Users
- `seed:UsersSeed` 生成名为UsersSeed的填充文件
- `seeder:UsersSeed` 填充名为UsersSeed的填充文件，目标表名为Users

> 请按照以上命名规则生成相对应文件，如要生成名为Users数据库表迁移文件，就执行如下命令`migration:UsersMigration`，数据库表填充文件如上方式。

## Changelog
### 2017.07.15
- 实现　Migration、Seeder 等基本功能
## Screenshots
## Discussing
- Author:godcheese
- Email:godcheese@outlook.com
- Homepage:http://www.gioov.com
