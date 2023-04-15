import request from '@/utils/request'

// 查询存储第三方物料类别信息列表
export function listK3BdMaterialcategory(query) {
  return request({
    url: '/system/k3cloud/k3BdMaterialcategory/list',
    method: 'get',
    params: query
  })
}

// 查询存储第三方物料类别信息详细
export function getK3BdMaterialcategory(id) {
  return request({
    url: '/system/k3cloud/k3BdMaterialcategory/' + id,
    method: 'get'
  })
}

// 新增存储第三方物料类别信息
export function addK3BdMaterialcategory(data) {
  return request({
    url: '/system/k3cloud/k3BdMaterialcategory',
    method: 'post',
    data: data
  })
}

// 修改存储第三方物料类别信息
export function updateK3BdMaterialcategory(data) {
  return request({
    url: '/system/k3cloud/k3BdMaterialcategory',
    method: 'put',
    data: data
  })
}

// 删除存储第三方物料类别信息
export function delK3BdMaterialcategory(id) {
  return request({
    url: '/system/k3cloud/k3BdMaterialcategory/' + id,
    method: 'delete'
  })
}


// 调用物料类别接口
export function k3WebApiAcquire() {
  return request({
    url: '/system/k3cloud/k3BdMaterialcategory/k3WebApiAcquire',
    method: 'post'
  })
}
