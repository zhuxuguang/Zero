import request from '@/utils/request'

// 查询组织间映射列表
export function listK3OrganizationMap(query) {
  return request({
    url: '/system/k3cloud/k3OrganizationMap/list',
    method: 'get',
    params: query
  })
}

// 查询组织间映射详细
export function getK3OrganizationMap(id) {
  return request({
    url: '/system/k3cloud/k3OrganizationMap/' + id,
    method: 'get'
  })
}

// 新增组织间映射
export function addK3OrganizationMap(data) {
  return request({
    url: '/system/k3cloud/k3OrganizationMap',
    method: 'post',
    data: data
  })
}

// 修改组织间映射
export function updateK3OrganizationMap(data) {
  return request({
    url: '/system/k3cloud/k3OrganizationMap',
    method: 'put',
    data: data
  })
}

// 删除组织间映射
export function delK3OrganizationMap(id) {
  return request({
    url: '/system/k3cloud/k3OrganizationMap/' + id,
    method: 'delete'
  })
}


// 查询部门下拉树结构
export function deptTreeSelect() {
  return request({
    url: '/system/k3cloud/k3OrganizationMap/deptTree',
    method: 'get'
  })
}


// 查询部门下拉树结构
export function k3OrganizationSelect() {
  return request({
    url: '/system/k3cloud/k3OrganizationMap/k3OrganizationSelect',
    method: 'get'
  })
}
