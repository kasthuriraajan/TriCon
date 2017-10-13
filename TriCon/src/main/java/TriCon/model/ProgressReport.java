
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

package TriCon.model;


import org.springframework.data.annotation.Id;

public class ProgressReport {
    @Id

    private String id;
    private String IndId;
    private String AuthLeave;
    private String UnAuthLeave;
    private String Attitude;
    private String Conduct;
    private String IndSign;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getIndId() {
        return IndId;
    }

    public void setIndId(String indId) {
        IndId = indId;
    }

    public String getAuthLeave() {
        return AuthLeave;
    }

    public void setAuthLeave(String authLeave) {
        AuthLeave = authLeave;
    }

    public String getUnAuthLeave() {
        return UnAuthLeave;
    }

    public void setUnAuthLeave(String unAuthLeave) {
        UnAuthLeave = unAuthLeave;
    }

    public String getAttitude() {
        return Attitude;
    }

    public void setAttitude(String attitude) {
        Attitude = attitude;
    }

    public String getConduct() {
        return Conduct;
    }

    public void setConduct(String conduct) {
        Conduct = conduct;
    }

    public String getIndSign() {
        return IndSign;
    }

    public void setIndSign(String indSign) {
        IndSign = indSign;
    }
}

