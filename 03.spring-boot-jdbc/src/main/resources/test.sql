-- 将此sql文件名更改为 schema-*.sql 或 data-*.sql可以在项目启动时加载sql文件。
--      schema-*.sql：创建表的SQL语句
--      data-*.sql：插入数据的SQL语句
-- 注意执行一次即可
--
-- 如果文件命名不按以上命名规则，可以在配置文件中指定sql文件
--      schema.classpath:文件名.sql
create table employee
(
    id        int primary key auto_increment,
    name      VARCHAR(30) not null,
    hire_date DATE,
    dept      VARCHAR(20)
);

INSERT into employee(name, hire_date, dept)values ('张三', '2019-10-10', '研发部');
INSERT into employee(name, hire_date, dept)values ('李四', '2019-2-3', '产品部');
INSERT into employee(name, hire_date, dept)values ('王五', '2018-10-12', '销售部');