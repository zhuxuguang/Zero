import request from '@/utils/request'

// 查询租金及摊销列表
export function listCbRentAndAmortization(query) {
  return request({
    url: '/system/cb/cbRentAndAmortization/list',
    method: 'get',
    params: query
  })
}

// 查询租金及摊销详细
export function getCbRentAndAmortization(id) {
  return request({
    url: '/system/cb/cbRentAndAmortization/' + id,
    method: 'get'
  })
}

// 新增租金及摊销
export function addCbRentAndAmortization(data) {
  return request({
    url: '/system/cb/cbRentAndAmortization',
    method: 'post',
    data: data
  })
}

// 修改租金及摊销
export function updateCbRentAndAmortization(data) {
  return request({
    url: '/system/cb/cbRentAndAmortization',
    method: 'put',
    data: data
  })
}

// 删除租金及摊销
export function delCbRentAndAmortization(id) {
  return request({
    url: '/system/cb/cbRentAndAmortization/' + id,
    method: 'delete'
  })
}
