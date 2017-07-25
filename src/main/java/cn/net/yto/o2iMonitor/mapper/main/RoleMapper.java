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

import java.util.List;

import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import cn.net.yto.o2iMonitor.entity.security.Role;

/**
 *
 * @author zhangxin
 * @since 2017年6月20日
 */
public interface RoleMapper {
    @Select("select * from t_o2i_monitor_role where id in (select role_id from t_o2i_monitor_user_role where user_id=#{id} and status = '1')")
    @Results({
    	@Result(id=true, column="id", property="id"),
        @Result(column="create_time", property = "createTime"),
        @Result(column="modify_time", property = "modifyTime")
    })
    List<Role> findRolesByUserId(Long id);
}
