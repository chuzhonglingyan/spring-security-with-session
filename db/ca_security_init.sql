/*
 Navicat MySQL Data Transfer

 Source Server         : localhost
 Source Server Type    : MySQL
 Source Server Version : 80015
 Source Host           : localhost:3306
 Source Schema         : certificate_authority

 Target Server Type    : MySQL
 Target Server Version : 80015
 File Encoding         : 65001

 Date: 22/04/2020 21:26:30
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for sys_menu
-- ----------------------------
DROP TABLE IF EXISTS `sys_menu`;
CREATE TABLE `sys_menu`  (
                             `id` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '菜单id',
                             `pid` bigint(20) NOT NULL COMMENT '父菜单id',
                             `name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '菜单名称',
                             `path` varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '菜单路径',
                             `type` tinyint(3) UNSIGNED NOT NULL COMMENT '菜单类型，0：根目录,1：菜单，2：操作',
                             `level` tinyint(3) NOT NULL DEFAULT 1 COMMENT '菜单等级 1一级菜单  2 二级菜单  3 三级菜单',
                             `sort` int(11) UNSIGNED NOT NULL DEFAULT 0 COMMENT '排序',
                             `component` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '组件',
                             `component_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '组件名称',
                             `permission` varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT '授权(多个用逗号分隔，如：user:list,user:add)',
                             `icon` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '图标',
                             `visible` tinyint(3) NOT NULL COMMENT '是否可见  0-否,1-是  默认0',
                             `cache` tinyint(3) NOT NULL DEFAULT 0 COMMENT '是否缓存  0-否,1-是  默认0',
                             `status` tinyint(3) UNSIGNED NOT NULL DEFAULT 0 COMMENT '菜单状态  0-禁用 ,1-启用  默认为0 ',
                             `is_linked` tinyint(3) NOT NULL DEFAULT 0 COMMENT '是否外链 0：否,1：是',
                             `create_id` bigint(20) NOT NULL COMMENT '创建人',
                             `create_time` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
                             `update_id` bigint(20) NOT NULL COMMENT '更新人',
                             `update_time` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '更新时间',
                             `is_delete` tinyint(3) UNSIGNED NOT NULL DEFAULT 0 COMMENT '是否删除，0-未删除，1-删除，默认为0',
                             PRIMARY KEY (`id`) USING BTREE,
                             INDEX `idx_menu_name`(`name`) USING BTREE,
                             INDEX `idx_menu_pid`(`pid`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 28 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '后台系统-菜单表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_menu
-- ----------------------------
INSERT INTO `sys_menu` VALUES (1, 0, '系统管理', 'in-system', 0, 1, 1, '', '', '', 'system', 1, 0, 1, 0, 1, '2020-02-23 00:35:12', 1, '2020-02-27 20:12:52', 0);
INSERT INTO `sys_menu` VALUES (2, 1, '用户管理', 'user', 1, 2, 4, 'system/user/index', 'User', 'user:list', 'peoples', 1, 0, 1, 0, 1, '2020-02-23 00:35:12', 1, '2020-02-27 11:53:47', 0);
INSERT INTO `sys_menu` VALUES (3, 1, '角色管理', 'role', 1, 2, 6, 'system/role/index', 'Role', 'roles:list', 'role', 1, 0, 1, 0, 1, '2020-02-23 00:35:12', 1, '2020-02-27 11:53:48', 0);
INSERT INTO `sys_menu` VALUES (5, 1, '菜单管理', 'menu', 1, 2, 5, 'system/menu/index', 'Menu', 'menu:list', 'menu', 1, 0, 1, 0, 1, '2020-02-23 00:35:12', 1, '2020-02-27 11:53:49', 0);
INSERT INTO `sys_menu` VALUES (6, 0, '系统监控', 'monitor', 0, 1, 10, '', '', '', 'monitor', 1, 0, 1, 0, 1, '2020-02-23 00:35:12', 1, '2020-02-27 11:53:50', 0);
INSERT INTO `sys_menu` VALUES (7, 6, '操作日志', 'logs', 1, 2, 11, 'monitor/log/index', 'Log', '', 'log', 1, 0, 1, 0, 1, '2020-02-23 00:35:12', 1, '2020-02-27 11:53:51', 0);
INSERT INTO `sys_menu` VALUES (12, 0, '工具栏', 'tools', 0, 1, 999, '', '', '', 'tools', 1, 0, 0, 0, 1, '2020-02-26 14:04:49', 1, '2020-02-27 11:53:53', 1);
INSERT INTO `sys_menu` VALUES (13, 0, '系统工具', 'in-sys-tools', 0, 1, 999, '', '', '', 'sys-tools', 1, 0, 1, 0, 1, '2020-02-26 15:06:26', 1, '2020-03-01 01:10:56', 0);
INSERT INTO `sys_menu` VALUES (14, 13, '定时任务', 'timing', 1, 1, 999, 'system/timing/index', 'Timing', 'timing:list', 'timing', 1, 0, 1, 0, 1, '2020-02-26 15:09:54', 1, '2020-02-27 16:23:52', 0);
INSERT INTO `sys_menu` VALUES (15, 2, '用户新增', '', 2, 3, 993, '', '', 'user:add', '', 0, 0, 1, 0, 1, '2020-02-26 19:32:53', 1, '2020-02-27 19:31:03', 0);
INSERT INTO `sys_menu` VALUES (16, 2, '用户编辑', '', 2, 3, 999, '', '', 'user:edit', '', 0, 0, 1, 0, 1, '2020-02-27 19:22:50', 1, '2020-02-27 19:31:07', 0);
INSERT INTO `sys_menu` VALUES (17, 2, '用户删除', '', 2, 3, 999, '', '', 'user:del', '', 0, 0, 1, 0, 1, '2020-02-27 19:27:37', 1, '2020-02-27 19:31:11', 0);
INSERT INTO `sys_menu` VALUES (18, 3, '角色新增', '', 2, 3, 999, '', '', 'role:add', '', 0, 0, 1, 0, 1, '2020-02-27 19:29:07', 1, '2020-02-27 20:31:32', 0);
INSERT INTO `sys_menu` VALUES (19, 3, '角色编辑', '', 2, 3, 999, '', '', 'role:edit', '', 0, 0, 1, 0, 1, '2020-02-27 19:29:56', 1, '2020-02-27 20:31:34', 0);
INSERT INTO `sys_menu` VALUES (20, 3, '角色删除', '', 2, 3, 999, '', '', 'role:del', '', 0, 0, 1, 0, 1, '2020-02-27 19:30:35', 1, '2020-02-27 20:31:36', 0);
INSERT INTO `sys_menu` VALUES (21, 5, '菜单新增', '', 2, 3, 999, '', '', 'menu:add', '', 0, 0, 1, 0, 1, '2020-02-27 19:32:00', 1, '2020-02-27 20:31:41', 0);
INSERT INTO `sys_menu` VALUES (22, 5, '菜单编辑', '', 2, 3, 999, '', '', 'menu:edit', '', 0, 0, 1, 0, 1, '2020-02-27 19:32:35', 1, '2020-02-27 20:31:46', 0);
INSERT INTO `sys_menu` VALUES (23, 5, '菜单删除', '', 2, 3, 999, '', '', 'menu:del', '', 0, 0, 1, 0, 1, '2020-02-27 19:33:17', 1, '2020-02-27 20:31:49', 0);
INSERT INTO `sys_menu` VALUES (24, 1, '字典管理', 'dict', 1, 2, 999, 'system/dict/index', 'Dict', 'dict:list', 'dictionary', 1, 0, 1, 0, 1, '2020-02-29 15:26:12', 1, '2020-02-29 15:29:39', 0);
INSERT INTO `sys_menu` VALUES (25, 24, '字典新增', '', 2, 3, 2, '', '', 'dict:add', '', 0, 0, 0, 0, 1, '2020-02-29 15:27:31', 1, '2020-02-29 15:27:31', 0);
INSERT INTO `sys_menu` VALUES (26, 24, '字典编辑', '', 2, 3, 3, '', '', 'dict:edit', '', 0, 0, 0, 0, 1, '2020-02-29 15:28:29', 1, '2020-02-29 15:28:29', 0);
INSERT INTO `sys_menu` VALUES (27, 24, '字典删除', '', 2, 3, 4, '', '', 'dict:del', '', 0, 0, 0, 0, 1, '2020-02-29 15:28:55', 1, '2020-02-29 15:28:55', 0);

-- ----------------------------
-- Table structure for sys_operator
-- ----------------------------
DROP TABLE IF EXISTS `sys_operator`;
CREATE TABLE `sys_operator`  (
                                 `id` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT,
                                 `user_name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '用户名',
                                 `nick_name` varchar(60) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '昵称',
                                 `pass_word` char(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '密码',
                                 `sex` tinyint(3) NOT NULL DEFAULT 0 COMMENT '0-男，1-女，默认为0',
                                 `email` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '邮箱',
                                 `avatar` varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '头像',
                                 `phone` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '电话',
                                 `status` tinyint(4) UNSIGNED NOT NULL DEFAULT 0 COMMENT '用户状态 0-禁用 ,1-启用  默认为0 ',
                                 `is_supper` tinyint(4) UNSIGNED NOT NULL DEFAULT 0 COMMENT '是否超管  0-否，1-是，默认为0',
                                 `create_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '创建人',
                                 `create_time` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
                                 `update_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '更新人',
                                 `update_time` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '更新时间',
                                 `is_delete` tinyint(3) UNSIGNED NOT NULL DEFAULT 0 COMMENT '是否删除，0-未删除，1-删除，默认为0',
                                 PRIMARY KEY (`id`) USING BTREE,
                                 UNIQUE INDEX `user_name`(`user_name`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 25 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '后台系统-用户表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_operator
-- ----------------------------
INSERT INTO `sys_operator` VALUES (1, 'admin', '哈哈', '$2a$10$lwKMc3ztPVwFTVuEaAICFuIc0g/HnJABna2QIZP0.Y/8YvQa8symS', 0, '944610721@qq.com', 'https://wpimg.wallstcn.com/f778738c-e4f8-4870-b634-56703b4acafe.gif', '134766550681', 1, 0, 1, '2020-02-01 22:36:03', 1, '2020-04-19 11:18:55', 0);
INSERT INTO `sys_operator` VALUES (2, 'yuntian', '嘿嘿', '$2a$10$lwKMc3ztPVwFTVuEaAICFuIc0g/HnJABna2QIZP0.Y/8YvQa8symS', 0, '944610721@qq.com', 'https://wpimg.wallstcn.com/f778738c-e4f8-4870-b634-56703b4acafe.gif', '13476550681', 1, 0, 1, '2020-02-01 23:39:24', 1, '2020-04-19 16:28:34', 0);
INSERT INTO `sys_operator` VALUES (4, 'hhh', 'xxx', '5Sa8E5cP1003eV0fD3br09Za5F79Z84S4c30cIdbifasc2X4', 0, '9446107221@qq.com', '', '13523232323', 0, 0, 1, '2020-02-25 20:49:06', 1, '2020-02-25 20:49:06', 0);
INSERT INTO `sys_operator` VALUES (5, 'dfdf', '2323', '5P4aU26w9bN70h96c77lcfc4aH0cR9fJaa746Sd3d7fj89Ld', 1, '332323@qq.com', '', '13523232323', 1, 0, 1, '2020-02-25 21:38:22', 1, '2020-02-25 22:05:27', 1);
INSERT INTO `sys_operator` VALUES (6, 'sdsd', '32323', '2zbdj16q86H2eZ6dZ65o9bP31A93Of2c13TcdL3eVedT30Va', 0, '232323@qq.com', '', '13223232323', 1, 0, 1, '2020-02-25 21:39:53', 1, '2020-02-26 11:38:58', 0);
INSERT INTO `sys_operator` VALUES (12, 'grrgrg', '3434', 'bI55f46MacT7cWfcEfbl7ec92N6ed42v88x5f501A1bE78H0', 0, 'wewe@qq.com', '', '13444444444', 0, 0, 1, '2020-02-26 00:00:34', 1, '2020-02-26 00:09:26', 1);
INSERT INTO `sys_operator` VALUES (13, 'teeee', 'xxx', '340bJcd3f6Q56E97Ad6j14d23V66q6bSb5Nfey0bDccod441', 0, '944610721@qq.com', '', '13434343434', 1, 0, 1, '2020-02-27 15:43:39', 1, '2020-02-27 15:59:00', 1);
INSERT INTO `sys_operator` VALUES (14, 'dgfgfg', 'erer', '5V10b70ufbG1e263C14p6bOa0l684ebifdi1cb49s6cm36Od', 0, '23@qq.com', '', '13434343433', 1, 0, 1, '2020-02-27 15:57:52', 1, '2020-02-27 15:59:09', 1);
INSERT INTO `sys_operator` VALUES (15, '3223232', '得到', '4H9bu95uc3la0he0v94f52Le9He3T02755acbq9eTc0yeet1', 0, '343@qq.com', '', '13434343434', 1, 0, 1, '2020-02-27 15:58:50', 1, '2020-02-27 16:08:08', 0);
INSERT INTO `sys_operator` VALUES (16, 'ererer', '34343', 'a8da3b0f5bL60z45J57o248feCcdmbdsfbOf4x8cMd7zcdPf', 0, '43432@qq.com', '', '13434343333', 0, 0, 1, '2020-02-27 16:08:44', 1, '2020-02-27 16:08:47', 1);
INSERT INTO `sys_operator` VALUES (17, 'dfdfd', 'erere', '51fcj08sbdhf5A78Be7d27K0cib0T5e4bfQ18S26i6eP87H5', 0, 'swee@qq.com', '', '13234343433', 0, 0, 1, '2020-02-27 16:09:42', 1, '2020-02-29 16:56:36', 1);
INSERT INTO `sys_operator` VALUES (18, 'xxxx', '3434', '1v0ej14a01Wa7haebf6p9728el83w74J74y54a3b8b5O37kf', 0, '343@qq.com', '', '13343434343', 0, 0, 1, '2020-02-29 20:16:11', 1, '2020-02-29 20:16:11', 0);
INSERT INTO `sys_operator` VALUES (19, 'dssdsds', '23', '4Bd5Ka3l2eUba7bfX5bf43Q1a25bI968b5Ub0Z743abc4236', 0, '2323@qq.com', '', '13323232322', 0, 0, 1, '2020-02-29 20:16:49', 1, '2020-02-29 20:18:37', 1);
INSERT INTO `sys_operator` VALUES (20, '34', '3434', '2e0di93ia1ZbcG17I75qeef6cJ36e765e4964Q67ibeN84Kc', 0, '3434343@qq.com', '', '13343434334', 0, 0, 1, '2020-03-01 15:31:29', 1, '2020-03-01 15:31:29', 0);
INSERT INTO `sys_operator` VALUES (21, 'eerer', '', '7909A0bZ1a0f6tceM6fo713eb464l7b7cd140hd502eDe6Nc', 0, 'sdsd@qq.com', '', '13343434334', 0, 0, 1, '2020-03-01 15:31:46', 1, '2020-03-01 15:31:46', 0);
INSERT INTO `sys_operator` VALUES (22, 'wwewew', '', '5Nd6h34w65e31xc4I4chc6D5ax664ecE95r3fBfd5cd66cE3', 0, 'wewe@qq.com', '', '13343434334', 0, 0, 1, '2020-03-01 15:31:58', 1, '2020-03-01 15:31:58', 0);
INSERT INTO `sys_operator` VALUES (23, 'wewewe', '', '1v15Qf0Y6cy03i8aUe3h19zb9U0bq98Cf0527b12V1eT6al6', 0, 'wwew@qq.com', '', '13343434334', 0, 0, 1, '2020-03-01 15:32:08', 1, '2020-03-01 15:32:08', 0);
INSERT INTO `sys_operator` VALUES (24, 'wewewew', '', '3s74F07992Hd9ua9c95d9cz765c9z7fP9ef729f6f9dja7L1', 0, 'wewe@qq.com', '', '13343434334', 1, 0, 1, '2020-03-01 15:32:19', 1, '2020-03-01 19:03:54', 0);

-- ----------------------------
-- Table structure for sys_operator_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_operator_role`;
CREATE TABLE `sys_operator_role`  (
                                      `id` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '主键id',
                                      `user_id` bigint(20) NOT NULL COMMENT '用户id',
                                      `role_id` bigint(20) NOT NULL COMMENT '角色id',
                                      `create_id` bigint(20) NOT NULL COMMENT '创建人',
                                      `create_time` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
                                      `update_id` bigint(20) NOT NULL COMMENT '更新人',
                                      `update_time` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '更新时间',
                                      PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 31 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '后台系统-用户角色关系表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_operator_role
-- ----------------------------
INSERT INTO `sys_operator_role` VALUES (1, 1, 1, 1, '2020-02-02 16:06:45', 1, '2020-02-02 16:06:45');
INSERT INTO `sys_operator_role` VALUES (10, 4, 3, 4, '2020-02-25 21:27:12', 4, '2020-02-25 21:27:12');
INSERT INTO `sys_operator_role` VALUES (11, 5, 3, 5, '2020-02-25 21:38:22', 5, '2020-02-25 21:38:22');
INSERT INTO `sys_operator_role` VALUES (18, 6, 2, 6, '2020-02-26 11:40:08', 6, '2020-02-26 11:40:08');
INSERT INTO `sys_operator_role` VALUES (21, 2, 3, 2, '2020-02-27 15:47:53', 2, '2020-02-27 15:47:53');
INSERT INTO `sys_operator_role` VALUES (22, 2, 2, 2, '2020-02-27 15:47:53', 2, '2020-02-27 15:47:53');
INSERT INTO `sys_operator_role` VALUES (29, 13, 2, 13, '2020-02-27 15:57:22', 13, '2020-02-27 15:57:22');
INSERT INTO `sys_operator_role` VALUES (30, 14, 2, 14, '2020-02-27 15:57:52', 14, '2020-02-27 15:57:52');

-- ----------------------------
-- Table structure for sys_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_role`;
CREATE TABLE `sys_role`  (
                             `id` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '主键ID',
                             `role_key` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '角色key',
                             `name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '角色名称',
                             `level` tinyint(3) NOT NULL DEFAULT 1 COMMENT '级别',
                             `status` tinyint(3) UNSIGNED NOT NULL DEFAULT 0 COMMENT '角色状态  0-禁用 ,1-启用  默认为0 ',
                             `remark` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT '备注',
                             `create_id` bigint(20) NOT NULL COMMENT '创建人',
                             `create_time` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
                             `update_id` bigint(20) NOT NULL COMMENT '更新人',
                             `update_time` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '更新时间',
                             `is_delete` tinyint(3) UNSIGNED NOT NULL DEFAULT 0 COMMENT '是否删除，0-未删除，1-删除，默认为0',
                             PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 8 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '后台系统-角色表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_role
-- ----------------------------
INSERT INTO `sys_role` VALUES (1, 'admin', '管理员', 4, 1, 'xx', 1, '2020-02-02 16:06:32', 1, '2020-03-01 19:19:42', 0);
INSERT INTO `sys_role` VALUES (2, 'test', '测试', 2, 1, 'hh', 1, '2020-02-02 16:13:32', 1, '2020-02-26 23:24:04', 0);
INSERT INTO `sys_role` VALUES (3, 'common', '普通用户', 3, 1, '问问', 1, '2020-02-25 20:45:26', 1, '2020-02-26 23:27:41', 0);
INSERT INTO `sys_role` VALUES (5, 'xxx', '幅度为', 3, 0, '大幅度热热', 1, '2020-02-26 20:46:49', 1, '2020-02-26 22:14:14', 1);
INSERT INTO `sys_role` VALUES (6, 'hhh', '辅导费', 3, 0, '就看见', 1, '2020-02-26 23:25:12', 1, '2020-02-27 15:34:17', 1);
INSERT INTO `sys_role` VALUES (7, 'kkk', 'xx', 3, 0, 'wewewe', 1, '2020-02-27 15:35:44', 1, '2020-02-27 19:05:19', 0);

-- ----------------------------
-- Table structure for sys_role_menu
-- ----------------------------
DROP TABLE IF EXISTS `sys_role_menu`;
CREATE TABLE `sys_role_menu`  (
                                  `id` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '主键id',
                                  `role_id` bigint(20) NOT NULL COMMENT '角色id',
                                  `menu_id` bigint(20) NOT NULL COMMENT '菜单id',
                                  `is_checked` tinyint(4) NOT NULL DEFAULT 0 COMMENT '菜单选择状态',
                                  `create_id` bigint(20) NOT NULL COMMENT '创建人',
                                  `create_time` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
                                  `update_id` bigint(20) NOT NULL COMMENT '更新人',
                                  `update_time` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '更新时间',
                                  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 101 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '后台系统-角色菜单关系表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_role_menu
-- ----------------------------
INSERT INTO `sys_role_menu` VALUES (7, 2, 2, 0, 1, '2020-02-23 21:15:21', 1, '2020-02-23 21:15:21');
INSERT INTO `sys_role_menu` VALUES (56, 7, 13, 0, 1, '2020-02-27 15:35:59', 1, '2020-02-27 15:35:59');
INSERT INTO `sys_role_menu` VALUES (57, 7, 14, 0, 1, '2020-02-27 15:35:59', 1, '2020-02-27 15:35:59');
INSERT INTO `sys_role_menu` VALUES (58, 3, 1, 0, 1, '2020-02-27 17:28:06', 1, '2020-02-27 17:28:06');
INSERT INTO `sys_role_menu` VALUES (59, 3, 2, 0, 1, '2020-02-27 17:28:06', 1, '2020-02-27 17:28:06');
INSERT INTO `sys_role_menu` VALUES (60, 3, 15, 0, 1, '2020-02-27 17:28:06', 1, '2020-02-27 17:28:06');
INSERT INTO `sys_role_menu` VALUES (61, 3, 5, 0, 1, '2020-02-27 17:28:06', 1, '2020-02-27 17:28:06');
INSERT INTO `sys_role_menu` VALUES (62, 3, 6, 0, 1, '2020-02-27 17:28:06', 1, '2020-02-27 17:28:06');
INSERT INTO `sys_role_menu` VALUES (63, 3, 7, 0, 1, '2020-02-27 17:28:06', 1, '2020-02-27 17:28:06');
INSERT INTO `sys_role_menu` VALUES (64, 3, 13, 0, 1, '2020-02-27 17:28:06', 1, '2020-02-27 17:28:06');
INSERT INTO `sys_role_menu` VALUES (65, 3, 14, 0, 1, '2020-02-27 17:28:06', 1, '2020-02-27 17:28:06');
INSERT INTO `sys_role_menu` VALUES (83, 1, 1, 0, 1, '2020-02-29 15:34:39', 1, '2020-02-29 15:34:39');
INSERT INTO `sys_role_menu` VALUES (84, 1, 2, 0, 1, '2020-02-29 15:34:39', 1, '2020-02-29 15:34:39');
INSERT INTO `sys_role_menu` VALUES (85, 1, 15, 0, 1, '2020-02-29 15:34:39', 1, '2020-02-29 15:34:39');
INSERT INTO `sys_role_menu` VALUES (86, 1, 16, 0, 1, '2020-02-29 15:34:39', 1, '2020-02-29 15:34:39');
INSERT INTO `sys_role_menu` VALUES (87, 1, 17, 0, 1, '2020-02-29 15:34:39', 1, '2020-02-29 15:34:39');
INSERT INTO `sys_role_menu` VALUES (88, 1, 3, 0, 1, '2020-02-29 15:34:39', 1, '2020-02-29 15:34:39');
INSERT INTO `sys_role_menu` VALUES (89, 1, 18, 0, 1, '2020-02-29 15:34:39', 1, '2020-02-29 15:34:39');
INSERT INTO `sys_role_menu` VALUES (90, 1, 19, 0, 1, '2020-02-29 15:34:39', 1, '2020-02-29 15:34:39');
INSERT INTO `sys_role_menu` VALUES (91, 1, 20, 0, 1, '2020-02-29 15:34:39', 1, '2020-02-29 15:34:39');
INSERT INTO `sys_role_menu` VALUES (92, 1, 5, 0, 1, '2020-02-29 15:34:39', 1, '2020-02-29 15:34:39');
INSERT INTO `sys_role_menu` VALUES (93, 1, 21, 0, 1, '2020-02-29 15:34:39', 1, '2020-02-29 15:34:39');
INSERT INTO `sys_role_menu` VALUES (94, 1, 22, 0, 1, '2020-02-29 15:34:39', 1, '2020-02-29 15:34:39');
INSERT INTO `sys_role_menu` VALUES (95, 1, 23, 0, 1, '2020-02-29 15:34:39', 1, '2020-02-29 15:34:39');
INSERT INTO `sys_role_menu` VALUES (96, 1, 24, 0, 1, '2020-02-29 15:34:39', 1, '2020-02-29 15:34:39');
INSERT INTO `sys_role_menu` VALUES (97, 1, 6, 0, 1, '2020-02-29 15:34:39', 1, '2020-02-29 15:34:39');
INSERT INTO `sys_role_menu` VALUES (98, 1, 7, 0, 1, '2020-02-29 15:34:39', 1, '2020-02-29 15:34:39');
INSERT INTO `sys_role_menu` VALUES (99, 1, 13, 0, 1, '2020-02-29 15:34:39', 1, '2020-02-29 15:34:39');
INSERT INTO `sys_role_menu` VALUES (100, 1, 14, 0, 1, '2020-02-29 15:34:39', 1, '2020-02-29 15:34:39');

SET FOREIGN_KEY_CHECKS = 1;
