// Licensed to the Apache Software Foundation (ASF) under one
// or more contributor license agreements.  See the NOTICE file
// distributed with this work for additional information
// regarding copyright ownership.  The ASF licenses this file
// to you under the Apache License, Version 2.0 (the
// "License"); you may not use this file except in compliance
// with the License.  You may obtain a copy of the License at
// 
//   http://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing,
// software distributed under the License is distributed on an
// "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
// KIND, either express or implied.  See the License for the
// specific language governing permissions and limitations
// under the License.
package org.apache.cloudstack.internallbvm;

import java.io.IOException;

import org.apache.cloudstack.network.lb.InternalLoadBalancerVMManager;
import org.apache.cloudstack.network.lb.dao.ApplicationLoadBalancerRuleDao;
import org.mockito.Mockito;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.core.type.classreading.MetadataReader;
import org.springframework.core.type.classreading.MetadataReaderFactory;
import org.springframework.core.type.filter.TypeFilter;

import com.cloud.configuration.ConfigurationManager;
import com.cloud.dc.dao.AccountVlanMapDaoImpl;
import com.cloud.network.NetworkManager;
import com.cloud.network.NetworkModel;
import com.cloud.network.dao.NetworkServiceMapDao;
import com.cloud.network.dao.PhysicalNetworkServiceProviderDao;
import com.cloud.network.dao.VirtualRouterProviderDao;
import com.cloud.user.AccountManager;
import com.cloud.utils.component.SpringComponentScanUtils;
import com.cloud.vm.dao.DomainRouterDao;

@Configuration
@ComponentScan(
    basePackageClasses={
        AccountVlanMapDaoImpl.class
    },
    includeFilters={@Filter(value=ElementChildTestConfiguration.Library.class, type=FilterType.CUSTOM)},
    useDefaultFilters=false
    )

public class ElementChildTestConfiguration {
    public static class Library implements TypeFilter { 
        @Bean
        public AccountManager accountManager() {
            return Mockito.mock(AccountManager.class);
        }
        
       
        @Bean
        public DomainRouterDao domainRouterDao() {
            return Mockito.mock(DomainRouterDao.class);
        }
        
        @Bean
        public VirtualRouterProviderDao virtualRouterProviderDao() {
            return Mockito.mock(VirtualRouterProviderDao.class);
        }
        
        @Bean
        public NetworkModel networkModel() {
            return Mockito.mock(NetworkModel.class);
        }
        
        
        @Bean
        public NetworkManager networkManager() {
            return Mockito.mock(NetworkManager.class);
        }

        
        @Bean
        public PhysicalNetworkServiceProviderDao physicalNetworkServiceProviderDao() {
            return Mockito.mock(PhysicalNetworkServiceProviderDao.class);
        }
        
        @Bean
        public NetworkServiceMapDao networkServiceMapDao() {
            return Mockito.mock(NetworkServiceMapDao.class);
        }
        
        @Bean
        public InternalLoadBalancerVMManager internalLoadBalancerVMManager() {
            return Mockito.mock(InternalLoadBalancerVMManager.class);
        }
        
        @Bean
        public ConfigurationManager confugurationManager() {
            return Mockito.mock(ConfigurationManager.class);
        }
        
        
        @Bean
        public ApplicationLoadBalancerRuleDao applicationLoadBalancerRuleDao() {
            return Mockito.mock(ApplicationLoadBalancerRuleDao.class);
        }
        
        @Override
        public boolean match(MetadataReader mdr, MetadataReaderFactory arg1) throws IOException {
            mdr.getClassMetadata().getClassName();
            ComponentScan cs = ElementChildTestConfiguration.class.getAnnotation(ComponentScan.class);
            return SpringComponentScanUtils.includedInBasePackageClasses(mdr.getClassMetadata().getClassName(), cs);
        }
    }
}
