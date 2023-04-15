import request from '@/utils/request'

// 查询存储第三方组织信息列表
export function listK3Organization(query) {
  return request({
    url: '/system/k3cloud/k3Organization/list',
    method: 'get',
    params: query
  })
}

// 查询存储第三方组织信息详细
export function getK3Organization(id) {
  return request({
    url: '/system/k3cloud/k3Organization/' + id,
    method: 'get'
  })
}

// 新增存储第三方组织信息
export function addK3Organization(data) {
  return request({
    url: '/system/k3cloud/k3Organization',
    method: 'post',
    data: data
  })
}

// 修改存储第三方组织信息
export function updateK3Organization(data) {
  return request({
    url: '/system/k3cloud/k3Organization',
    method: 'put',
    data: data
  })
}

// 删除存储第三方组织信息
export function delK3Organization(id) {
  return request({
    url: '/system/k3cloud/k3Organization/' + id,
    method: 'delete'
  })
}

// 主动获取成本分析报表
export function k3WebApiOrganizationAcquire() {
  return request({
    url: '/system/k3cloud/k3Organization/k3WebApiOrganizationAcquire',
    method: 'post'
  })
}
