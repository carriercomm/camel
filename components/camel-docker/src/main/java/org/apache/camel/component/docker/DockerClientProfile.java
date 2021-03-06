/**
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.apache.camel.component.docker;

import java.net.MalformedURLException;
import java.net.URL;

import org.apache.camel.component.docker.exception.DockerException;
import org.apache.camel.spi.UriParam;
import org.apache.camel.spi.UriParams;
import org.apache.camel.util.ObjectHelper;

/**
 * The elements representing a client initiating a connection to Docker
 */
@UriParams
public class DockerClientProfile {

    @UriParam(defaultValue = "localhost")
    private String host = "localhost";
    @UriParam(defaultValue = "2375")
    private Integer port = 2375;
    @UriParam
    private String username;
    @UriParam
    private String password;
    @UriParam
    private String email;
    @UriParam
    private String serverAddress;
    @UriParam
    private Integer requestTimeout;
    @UriParam
    private Boolean secure;
    @UriParam
    private String certPath;
    @UriParam(defaultValue = "100")
    private Integer maxTotalConnections = 100;
    @UriParam(defaultValue = "100")
    private Integer maxPerRouteConnections = 100;

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public Integer getPort() {
        return port;
    }

    public void setPort(Integer port) {
        this.port = port;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getServerAddress() {
        return serverAddress;
    }

    public void setServerAddress(String serverAddress) {
        this.serverAddress = serverAddress;
    }

    public Integer getRequestTimeout() {
        return requestTimeout;
    }

    public void setRequestTimeout(Integer requestTimeout) {
        this.requestTimeout = requestTimeout;
    }

    public Boolean isSecure() {
        return secure;
    }

    public void setSecure(Boolean secure) {
        this.secure = secure;
    }

    public String getCertPath() {
        return certPath;
    }

    public void setCertPath(String certPath) {
        this.certPath = certPath;
    }

    public Integer getMaxTotalConnections() {
        return maxTotalConnections;
    }

    public void setMaxTotalConnections(Integer maxTotalConnections) {
        this.maxTotalConnections = maxTotalConnections;
    }

    public Integer getMaxPerRouteConnections() {
        return maxPerRouteConnections;
    }

    public void setMaxPerRouteConnections(Integer maxPerRouteConnections) {
        this.maxPerRouteConnections = maxPerRouteConnections;
    }

    public String toUrl() throws DockerException {
        ObjectHelper.notNull(this.host, "host");
        ObjectHelper.notNull(this.port, "port");

        URL uri;
        String secure = this.secure != null && this.secure ? "https" : "http";
        try {
            uri = new URL(secure, this.host, this.port, "");
        } catch (MalformedURLException e) {
            throw new DockerException(e);
        }

        return uri.toString();

    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((certPath == null) ? 0 : certPath.hashCode());
        result = prime * result + ((email == null) ? 0 : email.hashCode());
        result = prime * result + ((host == null) ? 0 : host.hashCode());
        result = prime * result + ((maxPerRouteConnections == null) ? 0 : maxPerRouteConnections.hashCode());
        result = prime * result + ((maxTotalConnections == null) ? 0 : maxTotalConnections.hashCode());
        result = prime * result + ((password == null) ? 0 : password.hashCode());
        result = prime * result + ((port == null) ? 0 : port.hashCode());
        result = prime * result + ((requestTimeout == null) ? 0 : requestTimeout.hashCode());
        result = prime * result + ((secure == null) ? 0 : secure.hashCode());
        result = prime * result + ((serverAddress == null) ? 0 : serverAddress.hashCode());
        result = prime * result + ((username == null) ? 0 : username.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        DockerClientProfile other = (DockerClientProfile) obj;
        if (certPath == null) {
            if (other.certPath != null) {
                return false;
            }
        } else if (!certPath.equals(other.certPath)) {
            return false;
        }
        if (email == null) {
            if (other.email != null) {
                return false;
            }
        } else if (!email.equals(other.email)) {
            return false;
        }
        if (host == null) {
            if (other.host != null) {
                return false;
            }
        } else if (!host.equals(other.host)) {
            return false;
        }
        if (maxPerRouteConnections == null) {
            if (other.maxPerRouteConnections != null) {
                return false;
            }
        } else if (!maxPerRouteConnections.equals(other.maxPerRouteConnections)) {
            return false;
        }
        if (maxTotalConnections == null) {
            if (other.maxTotalConnections != null) {
                return false;
            }
        } else if (!maxTotalConnections.equals(other.maxTotalConnections)) {
            return false;
        }
        if (password == null) {
            if (other.password != null) {
                return false;
            }
        } else if (!password.equals(other.password)) {
            return false;
        }
        if (port == null) {
            if (other.port != null) {
                return false;
            }
        } else if (!port.equals(other.port)) {
            return false;
        }
        if (requestTimeout == null) {
            if (other.requestTimeout != null) {
                return false;
            }
        } else if (!requestTimeout.equals(other.requestTimeout)) {
            return false;
        }
        if (secure == null) {
            if (other.secure != null) {
                return false;
            }
        } else if (!secure.equals(other.secure)) {
            return false;
        }
        if (serverAddress == null) {
            if (other.serverAddress != null) {
                return false;
            }
        } else if (!serverAddress.equals(other.serverAddress)) {
            return false;
        }
        if (username == null) {
            if (other.username != null) {
                return false;
            }
        } else if (!username.equals(other.username)) {
            return false;
        }
        return true;
    }

}
