## Java2Sql
- java2sql-cli
- 用Java代码生成SQL语句
- 目前只支持MySQL

- 适配器 MySqlAdapter
- 目前组件 Migration（表管理）、Seeder（数据管理）

## TODO
- [x] MySqlAdapter
- [x] Migration
- [ ] Seeder
- [ ] Console/Terminal 上运行
- [ ] 优化代码

## Requirements
- Windows/Linux/macOS
- JDK 1.7+
## Installation

## Quick Start

#### Action

- `Seeds` 文件夹存放生成的数据库表填充数据文件
- `Migrations` 文件夹存放生成的数据表迁移文件

- `migration:UsersMigration` 生成名为UsersMigration的迁移文件
- `migrate:UsersMigration` 迁移名为UsersMigration的迁移文件，目标名为Users
- `seed:UsersSeed` 生成名为UsersSeed的填充文件
- `seeder:UsersSeed` 填充名为UsersSeed的填充文件，目标表名为Users


## Changelog
### 2017.07.15
- 实现　Migration、Seeder 等基本功能
## Screenshots
## Discussing
- Email:godcheese@outlook.com
- Homepage:http://www.gioov.com
