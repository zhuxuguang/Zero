import request from '@/utils/request'

// 查询存栏情况列表
export function listCbBreedingStock(query) {
  return request({
    url: '/system/cb/cbBreedingStock/list',
    method: 'get',
    params: query
  })
}

// 查询存栏情况详细
export function getCbBreedingStock(id) {
  return request({
    url: '/system/cb/cbBreedingStock/' + id,
    method: 'get'
  })
}

// 新增存栏情况
export function addCbBreedingStock(data) {
  return request({
    url: '/system/cb/cbBreedingStock',
    method: 'post',
    data: data
  })
}

// 修改存栏情况
export function updateCbBreedingStock(data) {
  return request({
    url: '/system/cb/cbBreedingStock',
    method: 'put',
    data: data
  })
}

// 删除存栏情况
export function delCbBreedingStock(id) {
  return request({
    url: '/system/cb/cbBreedingStock/' + id,
    method: 'delete'
  })
}
