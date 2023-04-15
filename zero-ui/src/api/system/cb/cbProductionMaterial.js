import request from '@/utils/request'

// 查询生产领料列表
export function listCbProductionMaterial(query) {
  return request({
    url: '/system/cb/cbProductionMaterial/list',
    method: 'get',
    params: query
  })
}

// 查询生产领料详细
export function getCbProductionMaterial(id) {
  return request({
    url: '/system/cb/cbProductionMaterial/' + id,
    method: 'get'
  })
}

// 新增生产领料
export function addCbProductionMaterial(data) {
  return request({
    url: '/system/cb/cbProductionMaterial',
    method: 'post',
    data: data
  })
}

// 修改生产领料
export function updateCbProductionMaterial(data) {
  return request({
    url: '/system/cb/cbProductionMaterial',
    method: 'put',
    data: data
  })
}

// 删除生产领料
export function delCbProductionMaterial(id) {
  return request({
    url: '/system/cb/cbProductionMaterial/' + id,
    method: 'delete'
  })
}

// 合并第三方单据
export function mergeCbProductionMaterial() {
  return request({
    url: '/system/cb/cbProductionMaterial/merge',
    method: 'post'
  })
}
