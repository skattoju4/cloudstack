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

import com.cloud.agent.AgentManager;
import com.cloud.configuration.dao.ConfigurationDao;
import com.cloud.dc.dao.AccountVlanMapDaoImpl;
import com.cloud.dc.dao.DataCenterDao;
import com.cloud.network.NetworkManager;
import com.cloud.network.NetworkModel;
import com.cloud.network.dao.NetworkDao;
import com.cloud.network.dao.PhysicalNetworkServiceProviderDao;
import com.cloud.network.dao.VirtualRouterProviderDao;
import com.cloud.network.lb.LoadBalancingRulesManager;
import com.cloud.offerings.dao.NetworkOfferingDao;
import com.cloud.resource.ResourceManager;
import com.cloud.service.dao.ServiceOfferingDao;
import com.cloud.storage.dao.VMTemplateDao;
import com.cloud.user.AccountManager;
import com.cloud.utils.component.SpringComponentScanUtils;
import com.cloud.vm.VirtualMachineManager;
import com.cloud.vm.dao.DomainRouterDao;
import com.cloud.vm.dao.NicDao;

@Configuration
@ComponentScan(
    basePackageClasses={
        AccountVlanMapDaoImpl.class
    },
    includeFilters={@Filter(value=LbChildTestConfiguration.Library.class, type=FilterType.CUSTOM)},
    useDefaultFilters=false
    )

    public class LbChildTestConfiguration {
        
        public static class Library implements TypeFilter {
            
          
            @Bean
            public AccountManager accountManager() {
                return Mockito.mock(AccountManager.class);
            }
            
            @Bean
            public VirtualMachineManager virtualMachineManager() {
                return Mockito.mock(VirtualMachineManager.class);
            }
            
            @Bean
            public DomainRouterDao domainRouterDao() {
                return Mockito.mock(DomainRouterDao.class);
            }
            
            @Bean
            public ConfigurationDao configurationDao() {
                return Mockito.mock(ConfigurationDao.class);
            }
            
            @Bean
            public VirtualRouterProviderDao virtualRouterProviderDao() {
                return Mockito.mock(VirtualRouterProviderDao.class);
            }
            
            @Bean
            public ApplicationLoadBalancerRuleDao applicationLoadBalancerRuleDao() {
                return Mockito.mock(ApplicationLoadBalancerRuleDao.class);
            }
            
            @Bean
            public NetworkModel networkModel() {
                return Mockito.mock(NetworkModel.class);
            }
            
            @Bean
            public LoadBalancingRulesManager loadBalancingRulesManager() {
                return Mockito.mock(LoadBalancingRulesManager.class);
            }
            
            @Bean
            public NicDao nicDao() {
                return Mockito.mock(NicDao.class);
            }
            
            @Bean
            public NetworkDao networkDao() {
                return Mockito.mock(NetworkDao.class);
            }
            
            @Bean
            public NetworkManager networkManager() {
                return Mockito.mock(NetworkManager.class);
            }
            
            @Bean
            public ServiceOfferingDao serviceOfferingDao() {
                return Mockito.mock(ServiceOfferingDao.class);
            }
            
            @Bean
            public PhysicalNetworkServiceProviderDao physicalNetworkServiceProviderDao() {
                return Mockito.mock(PhysicalNetworkServiceProviderDao.class);
            }
            
            @Bean
            public NetworkOfferingDao networkOfferingDao() {
                return Mockito.mock(NetworkOfferingDao.class);
            }
            
            @Bean
            public VMTemplateDao vmTemplateDao() {
                return Mockito.mock(VMTemplateDao.class);
            }
            
            @Bean
            public ResourceManager resourceManager() {
                return Mockito.mock(ResourceManager.class);
            }
            
            @Bean
            public AgentManager agentManager() {
                return Mockito.mock(AgentManager.class);
            }
            
            @Bean
            public DataCenterDao dataCenterDao() {
                return Mockito.mock(DataCenterDao.class);
            }
            
            @Override
            public boolean match(MetadataReader mdr, MetadataReaderFactory arg1) throws IOException {
                mdr.getClassMetadata().getClassName();
                ComponentScan cs = LbChildTestConfiguration.class.getAnnotation(ComponentScan.class);
                return SpringComponentScanUtils.includedInBasePackageClasses(mdr.getClassMetadata().getClassName(), cs);
            }
    
        }
}
