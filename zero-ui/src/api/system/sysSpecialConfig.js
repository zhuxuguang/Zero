import request from '@/utils/request'

// 查询专项参数配置列表
export function listSysSpecialConfig(query) {
  return request({
    url: '/system/sysSpecialConfig/list',
    method: 'get',
    params: query
  })
}

// 查询专项参数配置详细
export function getSysSpecialConfig(configId) {
  return request({
    url: '/system/sysSpecialConfig/' + configId,
    method: 'get'
  })
}

// 新增专项参数配置
export function addSysSpecialConfig(data) {
  return request({
    url: '/system/sysSpecialConfig',
    method: 'post',
    data: data
  })
}

// 修改专项参数配置
export function updateSysSpecialConfig(data) {
  return request({
    url: '/system/sysSpecialConfig',
    method: 'put',
    data: data
  })
}

// 删除专项参数配置
export function delSysSpecialConfig(configId) {
  return request({
    url: '/system/sysSpecialConfig/' + configId,
    method: 'delete'
  })
}
