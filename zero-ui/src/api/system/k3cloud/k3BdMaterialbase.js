import request from '@/utils/request'

// 查询存储物料信息列表
export function listK3BdMaterialbase(query) {
  return request({
    url: '/system/k3cloud/k3BdMaterialbase/list',
    method: 'get',
    params: query
  })
}

// 查询存储物料信息详细
export function getK3BdMaterialbase(id) {
  return request({
    url: '/system/k3cloud/k3BdMaterialbase/' + id,
    method: 'get'
  })
}

// 新增存储物料信息
export function addK3BdMaterialbase(data) {
  return request({
    url: '/system/k3cloud/k3BdMaterialbase',
    method: 'post',
    data: data
  })
}

// 修改存储物料信息
export function updateK3BdMaterialbase(data) {
  return request({
    url: '/system/k3cloud/k3BdMaterialbase',
    method: 'put',
    data: data
  })
}

// 删除存储物料信息
export function delK3BdMaterialbase(id) {
  return request({
    url: '/system/k3cloud/k3BdMaterialbase/' + id,
    method: 'delete'
  })
}

// 调用物料接口
export function k3WebApiAcquire() {
  return request({
    url: '/system/k3cloud/k3BdMaterialbase/k3WebApiAcquire',
    method: 'post'
  })
}
