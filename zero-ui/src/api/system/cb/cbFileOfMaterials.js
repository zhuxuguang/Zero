import request from '@/utils/request'

// 查询物料档案列表
export function listCbFileOfMaterials(query) {
  return request({
    url: '/system/cb/cbFileOfMaterials/list',
    method: 'get',
    params: query
  })
}

// 查询物料档案详细
export function getCbFileOfMaterials(id) {
  return request({
    url: '/system/cb/cbFileOfMaterials/' + id,
    method: 'get'
  })
}

// 新增物料档案
export function addCbFileOfMaterials(data) {
  return request({
    url: '/system/cb/cbFileOfMaterials',
    method: 'post',
    data: data
  })
}

// 修改物料档案
export function updateCbFileOfMaterials(data) {
  return request({
    url: '/system/cb/cbFileOfMaterials',
    method: 'put',
    data: data
  })
}

// 删除物料档案
export function delCbFileOfMaterials(id) {
  return request({
    url: '/system/cb/cbFileOfMaterials/' + id,
    method: 'delete'
  })
}
