
/*
 *  Copyright 2017 copyright to triconnect2017@gmail.com
 *
 *
 *
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *
 *    you may not use this file except in compliance with the License.
 *
 *    You may obtain a copy of the License at
 *
 *
 *
 *        http://www.apache.org/licenses/LICENSE-2.0
 *
 *
 *
 *    Unless required by applicable law or agreed to in writing, software
 *
 *    distributed under the License is distributed on an "AS IS" BASIS,
 *
 *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *
 *    See the License for the specific language governing permissions and
 *
 *    limitations under the License
 */

package TriCon.config;



import TriCon.model.User;
import TriCon.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.access.AccessDeniedHandler;
import java.util.List;

@Configuration
// http://docs.spring.io/spring-boot/docs/current/reference/html/howto-security.html
// Switch off the Spring Boot security configuration
//@EnableWebSecurity
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private AccessDeniedHandler accessDeniedHandler;
    private String roles1;
    // roles admin allow to access /admin/**
    // roles user allow to access /user/**
    // custom 403 access denied handler
    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http    .csrf().disable()
                .authorizeRequests()
                .antMatchers("/","/login","/register","/register","/registerDept", "/homepage", "/about").permitAll()
                /*.antMatchers("/admin/**").hasAnyRole("Admin")*/
                .antMatchers("/DeptAdmin/**").hasAnyRole("DeptAdmin")
                .antMatchers("/Stu/**").hasAnyRole("Student")
                .antMatchers("/Lec/**").hasAnyRole("Lecturer")
                .antMatchers("/Ind/**").hasAnyRole("Industrialist")

                /*.anyRequest().authenticated()*/
                .and()
                .formLogin()
                .loginPage("/").defaultSuccessUrl("/homepage")
                .permitAll()
                .and()
                .logout()
                .permitAll()
                .and()
                .exceptionHandling().accessDeniedHandler(accessDeniedHandler);
    }
    @Autowired
    private UserRepository userRepository;

 /*   @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {

        auth.inMemoryAuthentication()
                .withUser("user@gmail").password("kkk").roles("Student")
                .and()
                .withUser("admin@gmail.co").password("password").roles("Lecturer");
    }*/

   @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception{
        List<User> u1=userRepository.findAll();
        for (int i=0;i<u1.size();i++)
        {
            auth.inMemoryAuthentication().withUser(u1.get(i).getEmail()).password(u1.get(i).getPassword()).roles(u1.get(i).getType());
        }



   }
    /*
    //Spring Boot configured this already.
    @Override
    public void configure(WebSecurity web) throws Exception {
        web
                .ignoring()
                .antMatchers("/resources/**", "/static/**", "/css/**", "/js/**", "/images/**");
    }*/

}
