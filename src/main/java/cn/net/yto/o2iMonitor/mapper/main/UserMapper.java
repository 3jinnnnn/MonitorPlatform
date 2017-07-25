/*
 * Copyright © 2015-2017 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package cn.net.yto.o2iMonitor.mapper.main;

import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import cn.net.yto.o2iMonitor.entity.security.User;


/**
 * 用户表Mapper.
 * @author zhangxin
 * @since 2017年6月16日
 */
public interface UserMapper {
    
    @Select(value="SELECT * FROM t_o2i_monitor_user where username=#{username}")
    @Results({
        @Result(id=true, column="id", property="id"),
        @Result(column="create_time", property = "createTime"),
        @Result(column="modify_time", property = "modifyTime"),
        @Result(column="id", property="roles", many=@Many(select="cn.net.yto.o2iMonitor.mapper.main.RoleMapper.findRolesByUserId"))
    })
    User findByUsername(String username);
}
